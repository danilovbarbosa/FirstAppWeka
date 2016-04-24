package br.ufal.util;

public class Coordenada {

	private int coordenada;
	
	public Coordenada(boolean coordenada) {
		super();
		if (coordenada){
			this.coordenada = 1;
		}else{
			this.coordenada = 0;
		}
	}
	
	public Coordenada(int coordenada) {
		super();
		this.coordenada = coordenada;
	}

	public int getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(int coordenada) {
		this.coordenada = coordenada;
	}

	@Override
	public String toString() {
		return this.coordenada + "";
	}
	
	
	
}
