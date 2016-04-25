package br.ufal.algorithms;

import java.util.ArrayList;
import java.util.Random;

import br.ufal.util.Cluster;
import br.ufal.util.Ponto;

public class AlgorithmKMeans {

	private int k; // number of clusters
	private int total_values, total_points, max_iterations;
	private ArrayList<Cluster> clusters;

	public AlgorithmKMeans(int k, int total_values, int total_points, int max_iterations) {
		super();
		this.k = k;
		this.total_values = total_values;
		this.total_points = total_points;
		this.max_iterations = max_iterations;
		this.clusters = new ArrayList<>();
	}

	// Função para verificar e retonar o centroid mais próximo;
	private int getIDNearestCenter(Ponto ponto) {
		double sum = 0.0;
		double min_dist;
		int id_cluster_center = 0;

		for (int i = 0; i <= this.total_values; i++) {
			sum += Math.pow(clusters.get(0).getCentralValue(i) - ponto.getValue(i), 2.0);
		}
		min_dist = Math.sqrt(sum);

		for (int i = 1; i < this.k; i++) {
			double dist;
			sum = 0.0;

			for (int j = 0; j < total_values; j++) {
				sum += Math.pow(clusters.get(i).getCentralValue(j) - ponto.getValue(j), 2.0);
			}

			dist = Math.sqrt(sum);

			if (dist < min_dist) {
				min_dist = dist;
				id_cluster_center = i;
			}
		}
		return id_cluster_center;
	}

	public void run(ArrayList<Ponto> pontos)  {
		if (this.k > total_points){
			return;
		}
		ArrayList<Integer> prohibited_indexes = new ArrayList<>();
		prohibited_indexes.add(-1);
		
		// escolhe valores de K distintos para o centroid dos clusters
		for(int i = 0; i < this.k; i++) {
			while(true) {
				Random random = new Random();
				int index_point = random.nextInt(total_points);

				if (!prohibited_indexes.contains(new Integer(index_point))){
					prohibited_indexes.add(index_point);
					pontos.get(index_point).setId_cluster(i);
					System.out.println(pontos.get(index_point).toString());
					Cluster cluster =  new Cluster(i, pontos.get(index_point));
					clusters.add(cluster);
					break;
				}
			}
		}
		int iter = 1;
		
		while (true) {
			boolean done = true;
			
			// associates each point to the nearest center
			for(int i = 0; i < total_points; i++) {
				int id_old_cluster = pontos.get(i).getId_cluster();
				int id_nearest_center = getIDNearestCenter(pontos.get(i));

				if(id_old_cluster != id_nearest_center) {
					if(id_old_cluster != -1) {
						clusters.get(id_old_cluster).removePonto(pontos.get(i).getId_point());
					}
					pontos.get(i).setId_cluster(id_nearest_center);
					clusters.get(id_nearest_center).addPonto(pontos.get(i));
					done = false;
				}		
			}
			// recalculating the center of each cluster
			for(int i = 0; i < this.k; i++) {
				for(int j = 0; j < total_values; j++)
				{
					int total_points_cluster = clusters.get(i).getTotalPontos();
					double sum = 0.0;

					if(total_points_cluster > 0) {
						for(int p = 0; p < total_points_cluster; p++) {
							sum += clusters.get(i).getPonto(p).getValue(j);
						}
						clusters.get(i).setCentralValue(j, sum / total_points_cluster);
					}
				}
			}
			
			if(done == true || iter >= max_iterations)
			{
				System.out.println("Fim do loop.");;
				break;
			}
			iter++;
		}
		
		// print elementos do cluster
		for(int i = 0; i < this.k; i++) {
			int total_points_cluster =  clusters.get(i).getTotalPontos();

			System.out.print("Cluster " + clusters.get(i).getId_cluster() + 1);
			System.out.println(" - Tamanho -  " + clusters.get(i).size());

			for(int j = 0; j < total_points_cluster; j++) {
				System.out.print("Ponto " + clusters.get(i).getPonto(j).getId_point() + 1);
				
				for(int p = 0; p < total_values; p++){
					System.out.print(clusters.get(i).getPonto(j).getValue(p));
				}
				String point_name = clusters.get(i).getPonto(j).getName();

				if(point_name != "") {
					System.out.print(" - " + point_name);
				}
				System.out.println();
			}

			System.out.print("Cluster values: ");

			for(int j = 0; j < total_values; j++){
				System.out.print(clusters.get(i).getCentralValue(j));
			}
			System.out.println();
			System.out.println();

		}
		
	}

}
