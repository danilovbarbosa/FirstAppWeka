package br.ufal.algorithms;

import java.util.ArrayList;

import br.ufal.util.Cluster;
import br.ufal.util.Point;

public class AlgorithmKMeans implements InterfaceAlgorithm {

	// Atrubutos auxiliares
	private Point pointAux;
	private int min, max;

	// Listas
	private ArrayList<Point> points;
	private ArrayList<Cluster> clusters;

	public AlgorithmKMeans(int min, int max) {
		super();
		this.points = new ArrayList<>();
		this.clusters = new ArrayList<>();
		this.min = min;
		this.max = max;
	}

	@Override
	public void run(String dataset) {
		iniciarPointsClusters();
	}
	
	private void iniciarPointsClusters (){
		// iniciando lista de points
		points = this.pointAux.createRandomPoints(this.min, this.max, 15);

		// iniciando lista de clusters e randomizando centroids
		for (int i = 0; i > 3; i++) {
			Cluster cluster = new Cluster(i);
			Point centroid = this.pointAux.randomPoints(this.min, this.max);
			cluster.setCentroid(centroid);
			clusters.add(cluster);
			cluster.toString();
		}
		
	}
	
	

}
