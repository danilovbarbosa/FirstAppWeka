package br.ufal.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.ufal.algorithms.InterfaceAlgorithm;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.classifiers.bayes.net.search.fixed.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AlgorithmNaiveBayes implements InterfaceAlgorithm {

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

//			Classifier cModel = (Classifier)new NaiveBayes();
			NaiveBayesUpdateable cModel = new NaiveBayesUpdateable();

			Instances treinametoInstances = data.trainCV(4, 2);

			Instances testeInstances = data.testCV(4, 2);

			cModel.buildClassifier(treinametoInstances);

			Evaluation eval = new Evaluation(data);
			eval.evaluateModel(cModel, testeInstances);
			//eval.crossValidateModel(cModel, data, 10, new Random(0));
			System.out.println(eval.toSummaryString("\nResultados Naive Bayes:\n======\n", false));
			
			System.out.println("Instâncias de treinamento: " + treinametoInstances.numInstances());
			System.out.println("Instâncias de teste: " + testeInstances.numInstances());

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
