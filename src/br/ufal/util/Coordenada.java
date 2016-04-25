package br.ufal.util;

public class Coordenada {
	
	private double coordenada;

	public Coordenada(double coordenada) {
		super();
		this.coordenada = coordenada;
	}

	public double getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(double coordenada) {
		this.coordenada = coordenada;
	}

	@Override
	public String toString() {
		return "Coordenada [coordenada=" + coordenada + "]";
	}
	
	

}
