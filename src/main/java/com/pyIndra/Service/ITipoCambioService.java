package com.pyIndra.Service;

import com.pyIndra.Domain.TipoCambio;

public interface ITipoCambioService {
	void registrarTipoCambio(TipoCambio tipoCambio) throws Exception;
	void modificarTipoCambio(TipoCambio tipoCambio) throws Exception;
}
