/**
 * 
 */
/**
 * @author danilo and João Paulo.
 *
 */
package br.ufal.app;

import br.ufal.algorithms.AlgorithmKMeans;
import br.ufal.algorithms.AlgorithmKMeansWeka;
import br.ufal.algorithms.AlgorithmKnn;
import br.ufal.algorithms.AlgorithmMultilayerPerceptron;
import br.ufal.algorithms.AlgorithmTreeDecision;


public class Main {

	public static void main(String[] args) {
//		AlgorithmKnn instanceKnn = new AlgorithmKnn(5);
//		instanceKnn.run("./datasets/zoo.arff");
//		
//		AlgorithmTreeDecision instanceTreeDecision = new AlgorithmTreeDecision();
//		instanceTreeDecision.run("./datasets/zoo.arff");
//		
//		AlgorithmMultilayerPerceptron instanceMLP = new AlgorithmMultilayerPerceptron();
//		instanceMLP.run("./datasets/zoo.arff");

		//AlgorithmKMeans kMeans = new AlgorithmKMeans(2, 15, 2, 20);
		//kMeans.run(null);;
		
		AlgorithmKMeansWeka kmw = new AlgorithmKMeansWeka(7);
		kmw.run("./datasets/zoo.arff");
		
	}

}
