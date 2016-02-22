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
import weka.core.Instance;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		 BufferedReader reader;
		try {
			// Before running the program, set the path of your '.aff' file.
			
			 reader = new BufferedReader(new FileReader("/home/danilo/weka-3-6-13/data/zoo.arff"));
			 Instances data = new Instances(reader);
			 reader.close();
			 // setting class attribute
			 data.setClassIndex(data.numAttributes() - 1);
			 
			 IbkCreator knn = new IbkCreator(30); // Number of neighbours: 30
			 Classifier classificadorKnn = knn.getNewClassifier();
			 
			 Instance animal = new Instance(18); // New instance for a Camel.

			 
//			 Instance animalTrain = new Instance(18); // New instance for a Camel.
//			 
//			 Instance animalTest = new Instance(18); // New instance for a Camel.

			 
			 
			 
			 animal.setValue(0, 1);
			 animal.setValue(1, 1);
			 animal.setValue(2, 0);
			 animal.setValue(3, 0);
			 animal.setValue(4, 1);
			 animal.setValue(5, 0);
			 animal.setValue(6, 0);
			 animal.setValue(7, 0);
			 animal.setValue(8, 1);
			 animal.setValue(9, 1);
			 animal.setValue(10, 1);
			 animal.setValue(11, 0);
			 animal.setValue(12, 0);
			 animal.setValue(13, 4);
			 animal.setValue(14, 1);
			 animal.setValue(15, 0);
			 animal.setValue(16, 0);
			 animal.setValue(17, 0);
			
			 data.add(animal);
			 
			 classificadorKnn.buildClassifier(data);
			 animal.setDataset(data);
			 
			 double[] resultados = classificadorKnn.distributionForInstance(animal); // Results
			 
			 DecimalFormat df = new DecimalFormat("0.0");
			 
			 System.out.println("The Classification Results:\n");	
			 
			 for (int i = 0; i < data.classAttribute().numValues(); i++){
				 
				 System.out.println(data.classAttribute().value(i) + ": " + df.format(resultados[i] * 100) + "%");
				
				 
			 }
			 
			 
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
