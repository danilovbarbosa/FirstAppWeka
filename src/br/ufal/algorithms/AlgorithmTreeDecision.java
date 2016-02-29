package br.ufal.algorithms;

import java.io.FileNotFoundException;
import java.io.IOException;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.filters.unsupervised.attribute.Remove;

public class AlgorithmTreeDecision implements InterfaceAlgorithm {

	public AlgorithmTreeDecision() {
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

			Instances treinametoInstances = data.trainCV(4, 2);

			

			Instances testeInstances = data.testCV(4, 2);

			

			Remove rm = new Remove();
			rm.setAttributeIndices("1"); // remove 1st attribute
			// classifier
			J48 j48 = new J48();
			j48.setUnpruned(true); // using an unpruned J48
			// meta-classifier
			FilteredClassifier fc = new FilteredClassifier();
			fc.setFilter(rm);
			fc.setClassifier(j48);
			// train and make predictions
			fc.buildClassifier(treinametoInstances);
			

			Evaluation eval = new Evaluation(data);
			eval.evaluateModel(fc, testeInstances);
			System.out.println(eval.toSummaryString("\nResultados Árvore de Decisão:\n======\n", false));
			
			System.out.println("Treinamento: " + treinametoInstances.numInstances());
			
			System.out.println("Treinamento teste: " + testeInstances.numInstances());
			
			for (int i = 0; i < testeInstances.numInstances(); i++) {
				double pred = fc.classifyInstance(testeInstances.instance(i));
				System.out.print("ID: " + testeInstances.instance(i).value(0));
				System.out.print(", actual: " + testeInstances.classAttribute().value((int) testeInstances.instance(i).classValue()));
				System.out.println(", predicted: " + testeInstances.classAttribute().value((int) pred));
			}

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
