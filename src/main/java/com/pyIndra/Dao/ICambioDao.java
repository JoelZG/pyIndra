package com.pyIndra.Dao;

import com.pyIndra.Domain.Cambio;

public interface ICambioDao {
	Cambio ObtenerTipoCambio(Double monto, String monOrigen, String monDestino) throws Exception;
}
