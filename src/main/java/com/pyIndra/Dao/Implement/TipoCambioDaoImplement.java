package com.pyIndra.Dao.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.pyIndra.Dao.ITipoCambioDao;
import com.pyIndra.Domain.TipoCambio;
import com.pyIndra.Util.Conexion;

@Repository
public class TipoCambioDaoImplement implements ITipoCambioDao{
	private PreparedStatement preQuery;

	@Override
	public void registrarTipoCambio(TipoCambio tipoCambio) throws Exception {
		// TODO Auto-generated method stub
		Connection conexion = Conexion.getInstance().getConnection();
		StringBuilder query = new StringBuilder();
		int i=1;
		query.append("insert into Tipo_Cambio(Moneda_Origen,Moneda_Destino,Tipo_Cambio)");
		StringBuilder values = new StringBuilder();
		values.append("values(?, ?, ?)");
		try {
			query.append(values.toString());
			preQuery = conexion.prepareStatement(query.toString());
			preQuery.setString(i++, tipoCambio.getMonedaOrigen());
			preQuery.setString(i++, tipoCambio.getMonedaDestino());
			preQuery.setDouble(i++, tipoCambio.getTipoCambio());
			
			preQuery.execute();
		}catch (Exception e) {
			throw e;
		}

	}
	
	@Override
	public void modificarTipoCambio(TipoCambio tipoCambio) throws Exception {
		// TODO Auto-generated method stub
		Connection conexion = Conexion.getInstance().getConnection();
		StringBuilder query = new StringBuilder();
		int i=1;
		//System.out.println(persona.idPersona + " dao");
		query.append("UPDATE Tipo_Cambio SET Tipo_Cambio=? WHERE Moneda_Origen = ? and Moneda_Destino = ?");
		try {
			preQuery=conexion.prepareStatement(query.toString());
			preQuery.setDouble(i++, tipoCambio.getTipoCambio());
			preQuery.setString(i++, tipoCambio.getMonedaOrigen());
			preQuery.setString(i++, tipoCambio.getMonedaDestino());
			
			preQuery.execute();
		}catch(Exception e) {
			throw e;
		}
	}
	
}
