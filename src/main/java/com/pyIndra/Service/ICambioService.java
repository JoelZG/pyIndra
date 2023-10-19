package com.pyIndra.Service;

import com.pyIndra.Domain.Cambio;

public interface ICambioService {
	Cambio ObtenerTipoCambio(Double monto, String monOrigen, String monDestino) throws Exception;
}
