/**
 * 
 */
package br.ufal.algorthims;

import weka.classifiers.Classifier;

/**
 * @author danilo
 *
 */
public interface IClassifierCreator {
	public Classifier getNewClassifier();

}
