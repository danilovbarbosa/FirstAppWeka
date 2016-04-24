package br.ufal.algorithms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import br.ufal.util.Cluster;
import br.ufal.util.Coordenada;
import br.ufal.util.Ponto;

public class AlgorithmKMeans implements InterfaceAlgorithm {

	private int k;
	private ArrayList<Cluster> clusters;
	private ArrayList<Ponto> auxPontos;

	public AlgorithmKMeans(int k) {
		super();
		this.k = k;
		this.clusters = new ArrayList<>();
		this.auxPontos = new ArrayList<>();

	}
	
	@Override
	public void run(String dataset){
		Ponto auxP;
		try {
			Reader in = new FileReader(dataset);
			for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
				auxP = new Ponto();
				for (String field : record) {
					//System.out.print(" " + field + ",");
					if (field.equals("true")){
						auxP.addCoordenada(new Coordenada(true));
					}else if(field.equals("false")){
						auxP.addCoordenada(new Coordenada(false));
					}else if(field.length() == 1){
						auxP.addCoordenada(new Coordenada(Integer.parseInt(field)));
					}
				}
			//System.out.println(auxP);
				this.auxPontos.add(auxP);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		for (int i = 0; i < this.k; i++) {
			this.clusters.add(new Cluster());
		}
		centroidInicial();
		
		//Distancia para cada centroi
		for (Ponto ponto : auxPontos) {
			int auxI = 0;
			double auxDist = 500.0;
			double auxCalcDist = 0.0;
			
			for (int i = 0; i < clusters.size(); i++) {
				auxCalcDist = ponto.distanciaEuclidiana(clusters.get(i).getCentroid());
				if (auxDist > auxCalcDist){
					auxDist = auxCalcDist;
					ponto.setDistanciaParaCentroid(auxDist);
					auxI = i;

				}
				if(i  == clusters.size() - 1){
					clusters.get(auxI).addCluster(ponto);
				}
			}
		}
		
//		for (Cluster c : clusters) {
//			System.out.println(c.getCluster().size());
//
//			c.calcPontoMedio();
////			if (c.getCluster().size() >= 1){
////			}
//		}
		
		
		System.out.println("FIM");
	}
	//Calculo dos centroids iniciais
	public void centroidInicial() {
		Random gerador = new Random();
		int numero;
		
		for (int i = 0; i < this.k; i++) {
			numero = gerador.nextInt(this.auxPontos.size());
			this.clusters.get(i).setCentroid(auxPontos.get(numero));
		}

	}


}
