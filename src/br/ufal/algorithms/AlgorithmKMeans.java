package br.ufal.algorithms;

import java.util.ArrayList;

import br.ufal.util.Cluster;
import br.ufal.util.Ponto;

public class AlgorithmKMeans implements InterfaceAlgorithm {

	// Atrubutos auxiliares
	private int min, max;
	private ArrayList<Ponto> ultimosCentroidesCalculados;
	private ArrayList<Ponto> centroidesCalculadosAtuais;
	private double distanciaAtualCentroides = 0;

	// Listas
	private ArrayList<Ponto> pontos;
	private ArrayList<Cluster> clusters;
	private int k;
	private int numeroDepontos;
	private int iteracaoAtual;

	public AlgorithmKMeans(int k, int max, int min, int numeroDePontos) {
		super();
		this.pontos = new ArrayList<Ponto>();
		this.clusters = new ArrayList<Cluster>();
		this.k = k;
		this.max = max;
		this.min = min;
		this.numeroDepontos = numeroDePontos;
		
		inicializarKmeans();
		
	}

	@Override
	public void run(String dataset) {
		calcularKmeans();
	}
	
	private void inicializarKmeans(){
		// iniciando lista de points
		this.pontos = Ponto.criarPontosAleatorios(this.min, this.max, this.numeroDepontos);

		// iniciando lista de clusters e randomizando centroids
		for (int i = 0; i < k; i++) {
			Cluster cluster = new Cluster(i);
			Ponto centroid = Ponto.inicializarPontoAleatorio(this.min, this.max);
			cluster.setCentroid(centroid);
			clusters.add(cluster);
			cluster.toString();
		}
		
		plotarPontosNosClusters();
		
	}
	
	private void calcularKmeans(){
		
		do{
			
			limparClusters();
			
			this.ultimosCentroidesCalculados = this.obterCentroides();
			
			distribuirPontosNosClusters();
			
			calcularCentroides();
			
			this.iteracaoAtual++;
			
			this.centroidesCalculadosAtuais = this.obterCentroides();
			
			this.distanciaAtualCentroides = 0;
			
			for (int i = 0; i < ultimosCentroidesCalculados.size(); i++){
				
				this.distanciaAtualCentroides += Ponto.calcularDistanciaEuclidiana(ultimosCentroidesCalculados.get(i), centroidesCalculadosAtuais.get(i));
				
				
				
			}
			
			System.out.println("-----------------------");
			System.out.println("Iteração atual: " + iteracaoAtual);
			System.out.println("Distância dos centróides: " + distanciaAtualCentroides);
			
			plotarPontosNosClusters();
			
		} while (distanciaAtualCentroides == 0);
		
	}
	
	private void limparClusters(){
		
		for (Cluster c : clusters){
			c.limparListaDePontos();
			
		}
		
	}
	
	private ArrayList<Ponto> obterCentroides(){
		
		ArrayList<Ponto> centroidesAuxiliar = new ArrayList<Ponto>(this.k);
		
		for (Cluster c : this.clusters){
			
			Ponto pontoAux = c.getCentroid();
			Ponto novoPonto = new Ponto(pontoAux.getCoordenadaX(), pontoAux.getCoordenadaY());
			centroidesAuxiliar.add(novoPonto);
			
			
		}
		
		return centroidesAuxiliar;
		
	}
	
	private void plotarPontosNosClusters(){
		
		for (int i = 0; i < k; i++){
			
			Cluster cluster = clusters.get(i);
			cluster.plotarPontosCluster();
			
		}
		
	}
	
	private void calcularCentroides(){
		
		for (Cluster c: clusters){
			
			double somaCoordenadaX = 0;
			double somaCoordenadaY = 0;
			
			ArrayList<Ponto> pontos = c.getPontos();
			
			int quantPontos = pontos.size();
			
			for (Ponto p: pontos){
				
				somaCoordenadaX += p.getCoordenadaX();
				somaCoordenadaY += p.getCoordenadaY();
				
			}
			
			Ponto centroide = c.getCentroid();
			
			if (quantPontos > 0){
				
				double novaCoordenadaX = somaCoordenadaX / quantPontos;
				double novaCoordenadaY = somaCoordenadaY / quantPontos;
				
				centroide.setCoordenadaX(novaCoordenadaX);
				centroide.setCoordenadaY(novaCoordenadaY);
				
			}
			
		}
		
	}
	
	private void distribuirPontosNosClusters(){
		
		double pontoMaximo = Double.MAX_VALUE;
		double pontoMinimo = max;
		
		int cluster = 0;
		
		double distanciaEntreOsPontos = 0.0;
		
		for (Ponto p : pontos){
			
			pontoMinimo = pontoMaximo;
			
			for (int i = 0; i < k; i++){
				
				Cluster clusterAux = clusters.get(i);
				distanciaEntreOsPontos = Ponto.calcularDistanciaEuclidiana(p, clusterAux.getCentroid());
				
				if (distanciaEntreOsPontos < pontoMinimo){
					
					pontoMinimo = distanciaEntreOsPontos;
					cluster = i;
					
				}
				
				p.setClusterPertencente(cluster);
				
				clusters.get(cluster).getPontos().add(p);
				
			}
			
		}
		
	}

}
