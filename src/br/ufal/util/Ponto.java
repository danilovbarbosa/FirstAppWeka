package br.ufal.util;

import java.util.ArrayList;
import java.util.Random;

public class Ponto {
		
	private ArrayList<Coordenada> coordenadas; 
	private int clusterPertencente;
	
	private double coordenadaX;
	private double coordenadaY;

	public Ponto(double x, double y) {
		// TODO Auto-generated constructor stub
	}
	
	
//	public Ponto(ArrayList<String> coordenadas) {
//		//Se verdadeiro então coordenada é tipo boolean, se não, então tipo int
//		super();
//		int aux;
//
//		for (int i = 0; i <= coordenadas.size(); i++){
//			if (coordenadas.get(i).equals("true")){
//				aux = 1;
//				this.coordenadas.add(new Coordenada(true, aux));
//			} else if(coordenadas.get(i).equals("false")){
//				aux = 0;
//				this.coordenadas.add(new Coordenada(true, aux));
//		
//			} else{
//				this.coordenadas.add(new Coordenada(false, Integer.getInteger(coordenadas.get(i))));
//			}
//
//		}
//
//	}


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


	public ArrayList<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(ArrayList<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
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

    
    public static double calcularDistanciaEuclidianaCoordenadas(Ponto p, Ponto centroid) {
        
    	double subtracaoA = 0;
    	double subtracaoB = 0;
    	for (int i = 0; i < p.getCoordenadas().size(); i++){
    		
    		subtracaoA = subtracaoA + centroid.getCoordenadas().get(i).getCoordenada() - p.getCoordenadas().get(i).getCoordenada();
    		
    	}
    	
    	for (int j = 0; j < p.getCoordenadas().size(); j++){
    		
    		
    		subtracaoB = subtracaoB + centroid.getCoordenadas().get(j).getCoordenada() - p.getCoordenadas().get(j).getCoordenada();
    	}
    	
        return Math.sqrt(Math.pow((subtracaoA), 2) + Math.pow((subtracaoB), 2));

    	
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
		return "Ponto [coordenadas=" + coordenadas + ", clusterPertencente=" + clusterPertencente + "]";
	}


    
    
    
    
    
	
}
