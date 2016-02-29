package br.ufal.algorithms;

import java.io.FileNotFoundException;
import java.io.IOException;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AlgorithmKnn implements InterfaceAlgorithm{
	
	private int neighbors;
	
	public AlgorithmKnn(int neighbors) {
		this.neighbors = neighbors;
	}

	@Override
	public void run(String dataset) {

		try {

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

			

			Instances testeInstances = data.testCV(4, 2);

			

			classificadorKnn.buildClassifier(treinametoInstances);

			Evaluation eval = new Evaluation(data);
			eval.evaluateModel(classificadorKnn, testeInstances);
			System.out.println(eval.toSummaryString("\nResultados KNN:\n======\n", false));
			
			System.out.println("Treinamento: " + treinametoInstances.numInstances());
			System.out.println("Treinamento teste: " + testeInstances.numInstances());

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
