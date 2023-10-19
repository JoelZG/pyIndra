package com.pyIndra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pyIndra.Domain.Cambio;
import com.pyIndra.Service.ICambioService;

@CrossOrigin("*")
@RestController
public class CambioController {
	@Autowired
	ICambioService service;
	
	@GetMapping("/cambio/{monto}/{monOrigen}/{monDestino}")
	public ResponseEntity<Cambio> getTipoCambio(@PathVariable Double monto,@PathVariable String monOrigen,@PathVariable String monDestino){
		System.out.println("hola - joel");
		System.out.println("hola - joel: " + monto);
		ResponseEntity<Cambio> response = null;
		Cambio cambio = new Cambio();
		try {
			cambio = service.ObtenerTipoCambio(monto, monOrigen, monDestino);
			if(cambio != null ) {
				response=new ResponseEntity<Cambio>(cambio, HttpStatus.OK);			
			}else {
				response=new ResponseEntity<Cambio>(cambio, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch(Exception e) {
			response = new ResponseEntity<Cambio>(cambio, HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;
	}
}
