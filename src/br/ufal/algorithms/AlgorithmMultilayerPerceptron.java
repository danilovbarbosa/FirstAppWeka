package br.ufal.algorithms;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AlgorithmMultilayerPerceptron implements InterfaceAlgorithm {

	@Override
	public void run(String dataset) {
		
		
		try {
			
			DataSource source = new DataSource(dataset);
			Instances data = source.getDataSet();
			
			if (data.classIndex() == -1) {
				data.setClassIndex(data.numAttributes() - 1);

			}
			
			MultilayerPerceptron mlp = new MultilayerPerceptron();
			
			mlp.setLearningRate(0.3);
			mlp.setMomentum(0.2);
<<<<<<< HEAD
			mlp.setTrainingTime(2000);
			mlp.setHiddenLayers("7");
=======
			mlp.setTrainingTime(500);
			mlp.setHiddenLayers("6");
>>>>>>> fe8cda2dcd5ee43d8b765d6c4d906ed8c0ecebf1
			
			data.resample(new Random(1));
			
			Instances treinametoInstances = data.trainCV(4, 2);

			Instances testeInstances = data.testCV(4, 2);
			
			mlp.buildClassifier(treinametoInstances);
			
			Evaluation eval = new Evaluation(data);
			
			eval.evaluateModel(mlp, testeInstances);
			//eval.crossValidateModel(mlp, data, 10, new Random(0));
			System.out.println(eval.toSummaryString("\nResultados MLP:\n======\n", false));
			
			System.out.println("Instâncias de treinamento: " + treinametoInstances.numInstances());
			System.out.println("Instâncias de teste: " + testeInstances.numInstances());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
