package br.ufal.util;

import java.util.ArrayList;

public class Ponto {
	
	private ArrayList<Coordenada> coordenadas;
	private double distanciaParaCentroid;

	public Ponto() {
		super();
		this.coordenadas = new ArrayList<>();
		this.distanciaParaCentroid = 0.0;
	}

	public double getDistanciaParaCentroid() {
		return distanciaParaCentroid;
	}

	public void setDistanciaParaCentroid(double distanciaParaCentroid) {
		this.distanciaParaCentroid = distanciaParaCentroid;
	}

	public void setCoordenadas(ArrayList<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}

	public ArrayList<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void addCoordenada(Coordenada coordenada) {
		this.coordenadas.add(coordenada);
	}
	
	public double distanciaEuclidiana(Ponto pontoY) {
		double soma = 0.0;
				
		for (Coordenada coordPontoX : coordenadas) {
			for (Coordenada coordPontoY : pontoY.getCoordenadas()) {
				soma = soma + Math.pow((coordPontoX.getCoordenada() - coordPontoY.getCoordenada()), 2);
			}
		}
//		this.distanciaParaCentroid = Math.sqrt(soma);		
		return Math.sqrt(soma);
	}

	@Override
	public String toString() {
		return "Ponto [coordenadas=" + coordenadas + ", distanciaParaCentroid=" + distanciaParaCentroid + "]";
	}

	
	
//	public double distanciaManhattan() {
//		double result;
//		
//		return result;
//	}
}
