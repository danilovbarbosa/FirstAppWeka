/**
 * 
 */
/**
 * @author danilo and João Paulo.
 *
 */
package br.ufal.app;

import br.ufal.algorthims.Knn;


public class Main {

	public static void main(String[] args) {
		Knn instanceKnn = new Knn(5);
		instanceKnn.runKNN("./datasets/zoo.arff");

		
		
	}

}
