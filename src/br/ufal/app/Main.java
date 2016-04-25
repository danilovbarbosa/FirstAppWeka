/**
 * 
 */
/**
 * @author danilo and João Paulo.
 *
 */
package br.ufal.app;

import java.util.ArrayList;

import br.ufal.algorithms.AlgorithmHierarchicalClusterer;
import br.ufal.algorithms.AlgorithmKMeans;
import br.ufal.algorithms.AlgorithmKMeansWeka;
import br.ufal.algorithms.AlgorithmKnn;
import br.ufal.algorithms.AlgorithmMultilayerPerceptron;
import br.ufal.algorithms.AlgorithmNetworkSom;
import br.ufal.algorithms.AlgorithmTreeDecision;
import br.ufal.util.Coordenada;
import br.ufal.util.Ponto;


public class Main {

	public static void main(String[] args) {
		String datasetARFF = "./datasets/zoo.arff";
		String datasetCSV = "./datasets/zoo.csv";

		
//		AlgorithmKnn instanceKnn = new AlgorithmKnn(5);
//		instanceKnn.run(datasetARFF);
//		
//		AlgorithmTreeDecision instanceTreeDecision = new AlgorithmTreeDecision();
//		instanceTreeDecision.run(datasetARFF);
//		
//		AlgorithmMultilayerPerceptron instanceMLP = new AlgorithmMultilayerPerceptron();
//		instanceMLP.run(datasetARFF);

//		AlgorithmKMeans instanceKkMeans = new AlgorithmKMeans(7);
//		instanceKkMeans.run(datasetCSV);
		
//		AlgorithmKMeansWeka kmw = new AlgorithmKMeansWeka(7);
//		kmw.run(datasetARFF);
		
//		AlgorithmHierarchicalClusterer instancehC = new AlgorithmHierarchicalClusterer(7);
//		instancehC.run(datasetARFF);
		
//		AlgorithmNetworkSom som = new AlgorithmNetworkSom();
//		som.run(datasetARFF);
		
		
		
		int total_points, total_values, K, max_iterations;
		boolean has_name;

		total_points = 101; 
		total_values = 101; 
		K = 7; 
		max_iterations = 100; 
		has_name = true;

		ArrayList<Ponto> points = new ArrayList<>();
		String point_name;

		ArrayList<Coordenada> values;
		for(int i = 0; i < total_points; i++){
			values = new ArrayList<>();

			for(int j = 0; j < total_values; j++){
				double value;
				value = 2.0;
				values.add(new Coordenada(value));
			}

			if(has_name) {
				point_name = "";
				Ponto p = new Ponto(i, values, point_name);
				points.add(p);
			}
			else{
				Ponto p = new Ponto(i, values);
				points.add(p);
			}
		}

		AlgorithmKMeans kmeans = new AlgorithmKMeans(K, total_points, total_values, max_iterations);
		kmeans.run(points);
		
	}

}
