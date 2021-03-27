package com.reto.tipocambio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reto.tipocambio.model.TipoCambio;

public interface TipoCambioDAO extends JpaRepository<TipoCambio, Integer>{
	
	//@Query("select u.tipocambio from TipoCambio u where u.monedaOrigen = %?1 and u.monedaDestino = %?2")
	//List<Double> findTipoCambio(String monedaOrigen, String monedaDestino);
}