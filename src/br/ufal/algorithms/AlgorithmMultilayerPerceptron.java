package br.ufal.algorithms;

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
			mlp.setTrainingTime(2000);
			mlp.setHiddenLayers("7");
			
			Instances treinametoInstances = data.trainCV(4, 2);

			Instances testeInstances = data.testCV(4, 2);
			
			mlp.buildClassifier(treinametoInstances);
			
			Evaluation eval = new Evaluation(data);
			
			eval.evaluateModel(mlp, testeInstances);
			
			System.out.println(eval.toSummaryString("\nResultados MLP:\n======\n", false));
			
			System.out.println("Instâncias de treinamento: " + treinametoInstances.numInstances());
			System.out.println("Instâncias de teste: " + testeInstances.numInstances());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
