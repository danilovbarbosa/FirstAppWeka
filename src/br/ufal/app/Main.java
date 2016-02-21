/**
 * 
 */
/**
 * @author danilo
 *
 */
package br.ufal.app;

import br.ufal.algorthims.IbkCreator;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		 BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("/home/danilo/weka-3-6-13/data/cpu.arff"));
			 Instances data = new Instances(reader);
			 reader.close();
			 // setting class attribute
			 data.setClassIndex(data.numAttributes() - 1);
			 
			 IbkCreator knn = new IbkCreator(2);
			 Classifier classificadorKnn = knn.getNewClassifier();
			 classificadorKnn.buildClassifier(data);
			 
			 
			 // evaluate classifier and print some statistics
			 Evaluation eval = new Evaluation(data);
			 eval.evaluateModel(classificadorKnn, data);
			 System.out.println(eval.toSummaryString("\nResults\n======\n", false));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
