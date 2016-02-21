/**
 * 
 */
/**
 * @author danilo
 *
 */
package br.ufal.algorthims;


import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;

public class IbkCreator implements IClassifierCreator {
	private final Integer ibkNeighbours;//Número de vizinhos para rodar o Knn

	public IbkCreator(Integer ibkNeighbours) {
		this.ibkNeighbours = ibkNeighbours;
	}

	@Override
	public Classifier getNewClassifier() {
		IBk iBk = new IBk();
		iBk.setKNN(ibkNeighbours);
		return iBk;
	}

}