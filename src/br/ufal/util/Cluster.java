package br.ufal.util;

import java.util.ArrayList;
import java.util.Random;

public class Cluster {

	private ArrayList<Ponto> cluster;
	private Ponto centroid;
	

	public Cluster() {
		super();
		this.cluster = new ArrayList<Ponto>();
//		this.centroid = centroid;
	}

	public ArrayList<Ponto> getCluster() {
		return cluster;
	}

	public void addCluster(Ponto ponto) {
		this.cluster.add(ponto);
	}

	public Ponto getCentroid() {
		return centroid;
	}

	public void setCentroid(Ponto centroid) {
		this.centroid = centroid;
	}

//	public Ponto randomCentroid() {
//		Random gerador = new Random();
//		int numero = gerador.nextInt(this.cluster.size());
//
//		this.centroid = this.cluster.get(numero);
//		return this.centroid;
//	}

	public void distParaCentroid(ArrayList<Ponto> pontos) {
		double dist;
		for (Ponto ponto : pontos) {
			dist = ponto.distanciaEuclidiana(centroid);
			ponto.setDistanciaParaCentroid(dist);
		}

	}
	public void calcPontoMedio() {
		Ponto pontoMedio = new Ponto();
		
		ArrayList<Integer> auxListaCoord = new ArrayList<>();

		for (int i = 0; i <= this.centroid.getCoordenadas().size(); i++) {
			int media = 0;
			for (Ponto ponto : cluster) {
				media = media + ponto.getCoordenadas().get(i).getCoordenada();
			}
			System.out.println("teste: " + media/this.centroid.getCoordenadas().size());

			auxListaCoord.add(media/this.centroid.getCoordenadas().size());
		}
//		System.out.println(auxListaCoord);

		for (Integer integer : auxListaCoord) {
			pontoMedio.addCoordenada(new Coordenada(integer.intValue()));
		}
		System.out.println("Anterior: " + this.centroid);
		this.centroid = pontoMedio;
		System.out.println("Atual: " + this.centroid);

	}

	@Override
	public String toString() {
		return "Cluster [cluster=" + cluster + ", centroid=" + centroid + "]";
	}
	
	

}
