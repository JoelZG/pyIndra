package com.pyIndra.Dao.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import com.pyIndra.Dao.ICambioDao;
import com.pyIndra.Domain.Cambio;
import com.pyIndra.Domain.TipoCambio;
import com.pyIndra.Util.Conexion;

import org.springframework.stereotype.Repository;

@Repository
public class CambioDaoImplement implements ICambioDao {
	private PreparedStatement preQuery;
	
	@Override
	public Cambio ObtenerTipoCambio(Double monto, String monOrigen, String monDestino) throws Exception {
		// TODO Auto-generated method stub
		Connection conexion = Conexion.getInstance().getConnection();
		Cambio cambio = new Cambio();
		String query1 = "select Moneda_Origen,Moneda_Destino,Tipo_Cambio "
				+ "from Tipo_Cambio where Moneda_Origen = ? and Moneda_Destino = ?";
		TipoCambio tipoCambio = new TipoCambio();
		try {
			preQuery = conexion.prepareStatement(query1);
			preQuery.setString(1, monOrigen);
			preQuery.setString(2, monDestino);
			ResultSet data = preQuery.executeQuery();
			if(data.next()) {
				if(Objects.nonNull(data)) {
					tipoCambio.setMonedaOrigen(data.getString("Moneda_Origen"));
					tipoCambio.setMonedaDestino(data.getString("Moneda_Destino"));
					tipoCambio.setTipoCambio(data.getDouble("Tipo_Cambio"));
				}
			}
		}catch(SQLException e) {
			System.out.println("arielita2");
			e.printStackTrace();
		}
		
		if(tipoCambio.getMonedaOrigen() == null) {
			cambio.setMonto(0.00);
			cambio.setMontoCambio(0.00);
			cambio.setMonedaOrigen("");
			cambio.setMonedaDestino("");
			cambio.setTipoCambio(0.00);
		}else {
			StringBuilder query = new StringBuilder();
			int i=1;
			query.append("insert into Cambio(Monto,Monto_Cambio,Moneda_Origen,Moneda_Destino,Tipo_Cambio)");
			StringBuilder values = new StringBuilder();
			values.append("values(?, ?, ?, ?, ?)");
			try {
				query.append(values.toString());
				preQuery = conexion.prepareStatement(query.toString());
				preQuery.setDouble(i++, monto);
				preQuery.setDouble(i++, monto * tipoCambio.getTipoCambio());
				preQuery.setString(i++, monOrigen);
				preQuery.setString(i++, monDestino);
				preQuery.setDouble(i++, tipoCambio.getTipoCambio());
				preQuery.execute();
			}catch (Exception e) {
				throw e;
			}		
			
			
			cambio.setMonto(monto);
			cambio.setMontoCambio(monto * tipoCambio.getTipoCambio());
			cambio.setMonedaOrigen(monOrigen);
			cambio.setMonedaDestino(monDestino);
			cambio.setTipoCambio(tipoCambio.getTipoCambio());
		}
		
		
		return cambio;
	}
}
