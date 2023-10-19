package com.pyIndra.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pyIndra.Domain.TipoCambio;
import com.pyIndra.Service.ITipoCambioService;

@CrossOrigin("*")
@RestController
public class TipoCambioController {
	@Autowired
	ITipoCambioService service;
	
	@PostMapping("/Api/TipoCambio/")
	public ResponseEntity<Boolean>registrarProducto(@RequestBody TipoCambio tipoCambio){
		System.out.println("hola - joel");
		System.out.println(tipoCambio.monedaOrigen);
		ResponseEntity<Boolean> response = null;
		try {
			service.registrarTipoCambio(tipoCambio);
			response = new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@PutMapping("/Api/TipoCambio/")
	public ResponseEntity<Boolean>modificarProducto(@RequestBody TipoCambio tipoCambio){
		//System.out.println(persona.nombres);
		ResponseEntity<Boolean> response = null;
		try {
			service.modificarTipoCambio(tipoCambio);
			response = new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			response = new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
}
