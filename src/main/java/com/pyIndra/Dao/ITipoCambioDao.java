package com.pyIndra.Dao;

import com.pyIndra.Domain.TipoCambio;

public interface ITipoCambioDao {
	void registrarTipoCambio(TipoCambio tipoCambio) throws Exception;
	void modificarTipoCambio(TipoCambio tipoCambio) throws Exception;
}
