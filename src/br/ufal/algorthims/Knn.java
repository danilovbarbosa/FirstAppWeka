package br.ufal.algorthims;

import java.io.FileNotFoundException;
import java.io.IOException;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class Knn {
	
	private int neighbors;
	
	public Knn(int neighbors) {
		this.neighbors = neighbors;
	}

	public void runKNN(String dataset) {

		try {
			// Before running the program, set the path of your '.aff' file.

			// DataSource source = new DataSource("./datasets/zoo.arff");
			DataSource source = new DataSource(dataset);
			Instances data = source.getDataSet();
			// setting class attribute

			if (data.classIndex() == -1) {
				data.setClassIndex(data.numAttributes() - 1);

			}

			IBk knn = new IBk();
			knn.setKNN(this.neighbors);
			Classifier classificadorKnn = knn;

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
