package com.pyIndra.Service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pyIndra.Dao.ITipoCambioDao;
import com.pyIndra.Domain.TipoCambio;
import com.pyIndra.Service.ITipoCambioService;

@Service
public class TipoCambioServiceImplement implements ITipoCambioService{
	
	@Autowired
	ITipoCambioDao dao;
	
	@Override
	public void registrarTipoCambio(TipoCambio tipoCambio) throws Exception {
		// TODO Auto-generated method stub
		dao.registrarTipoCambio(tipoCambio);
	}
	
	@Override
	public void modificarTipoCambio(TipoCambio tipoCambio) throws Exception {
		// TODO Auto-generated method stub
		dao.modificarTipoCambio(tipoCambio);
	}

}
