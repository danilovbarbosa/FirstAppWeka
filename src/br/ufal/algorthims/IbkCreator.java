/**
 * 
 */
/**
 * @author danilo and João Paulo
 *
 */
package br.ufal.algorthims;


import weka.classifiers.Classifier;
import weka.classifiers.lazy.IBk;

public class IbkCreator implements IClassifierCreator {
	private final Integer ibkNeighbours;//Number of neighbours to run KNN.

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