package br.ufal.util;

import java.util.ArrayList;
import java.util.Random;

public class Ponto {
		
	private double coordenadaX = 0.0;
	private double coordenadaY = 0.0;
	private int clusterPertencente;
	
	public Ponto(double coordenadaX, double coordenadaY) {
		super();
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
	}

	

	public double getCoordenadaX() {
		return coordenadaX;
	}


	public void setCoordenadaX(double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}



	public double getCoordenadaY() {
		return coordenadaY;
	}



	public void setCoordenadaY(double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	

	public int getClusterPertencente() {
		return clusterPertencente;
	}



	public void setClusterPertencente(int clusterPertencente) {
		this.clusterPertencente = clusterPertencente;
	}



	//Calculo da distância euclidiana entre dois pontos.
    public static double calcularDistanciaEuclidiana(Ponto p, Ponto centroid) {
        return Math.sqrt(Math.pow((centroid.getCoordenadaX() - p.getCoordenadaY()), 2) + Math.pow((centroid.getCoordenadaX() - p.getCoordenadaY()), 2));
    }
    
    //Random Points
    public static Ponto inicializarPontoAleatorio(int min, int max) {
    	Random random = new Random();

    	//Recebe valores de mínimo é máximo, então realiza o caluclo e retorna um novo ponto random.
    	double x = min + (max - min) * random.nextDouble();
    	double y = min + (max - min) * random.nextDouble();
    	return new Ponto(x,y);
		
	}
    
    public static ArrayList<Ponto> criarPontosAleatorios(int min, int max, int tamanhoLista) {
    	
    	ArrayList<Ponto> pontos = new ArrayList<Ponto>(tamanhoLista);
    	for(int i = 0; i <= tamanhoLista; i++) {
    		pontos.add(inicializarPontoAleatorio(min,max));
    	}
    	return pontos;
    }



	@Override
	public String toString() {
		return "Ponto (coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ")";
	}
    
    
    
    
    
    
	
}
