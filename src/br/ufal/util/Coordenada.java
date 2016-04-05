package br.ufal.util;

public class Coordenada {
	
	private boolean tipoBooleanOuInt;
	private int coordenada;
	public Coordenada(boolean tipoBooleanOuInt, int coordenada) {
		//Se verdadeiro então coordenada é tipo boolean, se não, então tipo int
		super();
		this.tipoBooleanOuInt = tipoBooleanOuInt;
		this.coordenada = coordenada;
	}
	
	public boolean isTipoBooleanOuInt() {
		return tipoBooleanOuInt;
	}

	public int getCoordenada() {
		return coordenada;
	}
	
	//Calculo da distância booleana entre dois pontos.
	public int calcularDistanciaBoolean (Coordenada coordenadaCentroid){
		if (this.coordenada == coordenadaCentroid.getCoordenada()){
			return 0;
		} else {
			return 1;
		}
		
	}
	
	//Calculo da distância euclidiana entre dois pontos.
    public static double calcularDistanciaEuclidiana(Ponto p, Ponto centroid) {
        return Math.sqrt(Math.pow((centroid.getCoordenadaX() - p.getCoordenadaY()), 2) + Math.pow((centroid.getCoordenadaX() - p.getCoordenadaY()), 2));
    }


}
