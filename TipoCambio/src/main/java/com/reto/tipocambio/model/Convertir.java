package com.reto.tipocambio.model;

public class Convertir {
	
	private double monto;
	private double montoconvertido;
	private String monedaorigen;
	private String monedadestino;
	private double tipocambio;
	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public double getMontoconvertido() {
		return montoconvertido;
	}
	public void setMontoconvertido(double montoconvertido) {
		this.montoconvertido = montoconvertido;
	}
	public String getMonedaorigen() {
		return monedaorigen;
	}
	public void setMonedaorigen(String monedaorigen) {
		this.monedaorigen = monedaorigen;
	}
	public String getMonedadestino() {
		return monedadestino;
	}
	public void setMonedadestino(String monedadestino) {
		this.monedadestino = monedadestino;
	}
	public double getTipocambio() {
		return tipocambio;
	}
	public void setTipocambio(double tipocambio) {
		this.tipocambio = tipocambio;
	}
}
