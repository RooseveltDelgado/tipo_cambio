package com.reto.tipocambio.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reto.tipocambio.dao.TipoCambioDAO;
import com.reto.tipocambio.model.Convertir;
import com.reto.tipocambio.model.TipoCambio;

import rx.Observable;


@RestController
@RequestMapping("tipocambio")
public class TipoCambioRest {
	@Autowired
	private TipoCambioDAO tipocambioDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody TipoCambio tipocambio) {
		tipocambioDAO.save(tipocambio);
	}
	
	@GetMapping("/convertir")
	public ResponseEntity<Convertir> convertir(@RequestBody Convertir convetir) throws Exception {
		
		List<TipoCambio> lista = tipocambioDAO.findAll();
		if (!lista.isEmpty()) {
			Observable.from(lista)
			.filter(entity -> convetir.getMonedaorigen().equals(entity.getMonedaOrigen()) && convetir.getMonedadestino().equals(entity.getMonedaDestino()))
			.last().subscribe(entity -> convetir.setTipocambio(entity.getTipocambio()));
			convetir.setMontoconvertido(convetir.getMonto()*convetir.getTipocambio());
		}
		return new ResponseEntity<Convertir>(convetir, HttpStatus.OK);
	}
	
	@GetMapping("tipo")
	public ResponseEntity<List<TipoCambio>> listar() throws Exception{
		List<TipoCambio> lista = new ArrayList<>();
		TipoCambio tipo = new TipoCambio();
		 tipo.setId(1);
		 tipo.setMonedaDestino("Soles");
		 tipo.setMonedaOrigen("Dólares");
		 tipo.setTipocambio(3.75);		
		lista.add(tipo);
		return new ResponseEntity<List<TipoCambio>>(lista, HttpStatus.OK);
	}
}
