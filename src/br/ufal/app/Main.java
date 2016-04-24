/**
 * 
 */
/**
 * @author danilo and João Paulo.
 *
 */
package br.ufal.app;

import br.ufal.algorithms.AlgorithmHierarchicalClusterer;
import br.ufal.algorithms.AlgorithmKMeans;
import br.ufal.algorithms.AlgorithmKMeansWeka;
import br.ufal.algorithms.AlgorithmKnn;
import br.ufal.algorithms.AlgorithmMultilayerPerceptron;
import br.ufal.algorithms.AlgorithmNetworkSom;
import br.ufal.algorithms.AlgorithmTreeDecision;


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
		
		AlgorithmNetworkSom som = new AlgorithmNetworkSom();
		som.run(datasetARFF);
		
	}

}
