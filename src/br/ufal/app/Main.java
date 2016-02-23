/**
 * 
 */
/**
 * @author danilo and João Paulo.
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
			// Before running the program, set the path of your '.aff' file.
			
			 reader = new BufferedReader(new FileReader("/home/lapec/zoo.arff"));
			 Instances data = new Instances(reader);
			 reader.close();
			 // setting class attribute
			 data.setClassIndex(data.numAttributes() - 1);
			 
			 IbkCreator knn = new IbkCreator(5); // Number of neighbours: 30
			 Classifier classificadorKnn = knn.getNewClassifier();
			 
			 
			 
			 Instances treinametoInstances = data.trainCV(4, 2);
			 
			 System.out.println("Treinamento: " + treinametoInstances.numInstances());
			 
			 Instances testeInstances = data.testCV(4, 2);
			 
			 System.out.println("Treinamento teste: " + testeInstances.numInstances());
			 
			 

			 
			 classificadorKnn.buildClassifier(treinametoInstances);

			 Evaluation eval = new Evaluation(data);
			 eval.evaluateModel(classificadorKnn, testeInstances);
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
