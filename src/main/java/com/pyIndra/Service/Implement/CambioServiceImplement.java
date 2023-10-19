package com.pyIndra.Service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyIndra.Dao.ICambioDao;
import com.pyIndra.Domain.Cambio;
import com.pyIndra.Service.ICambioService;

@Service
public class CambioServiceImplement implements ICambioService {
	
	@Autowired
	ICambioDao dao;
	
	@Override
	public Cambio ObtenerTipoCambio(Double monto, String monOrigen, String monDestino) throws Exception {
		// TODO Auto-generated method stub
		return dao.ObtenerTipoCambio(monto, monOrigen, monDestino);
	}
	
}
