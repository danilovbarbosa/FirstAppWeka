package br.ufal.algorithms;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SelfOrganizingMap;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AlgorithmNetworkSom implements InterfaceAlgorithm {

	@Override
	public void run(String dataset) {
		try {
			DataSource source = new DataSource(dataset);
			Instances data = source.getDataSet();
			
			data.deleteAttributeAt(0);
			data.deleteAttributeAt(16);

			SelfOrganizingMap som = new SelfOrganizingMap();
			

			som.setConvergenceEpochs(1000);
			
			

			som.setLearningRate(0.3);
			som.setOrderingEpochs(500);

			som.setHeight(2);
			som.setWidth(4);
			som.setCalcStats(true);
			som.buildClusterer(data);
			
			ClusterEvaluation evaluation = new ClusterEvaluation();
	        evaluation.setClusterer(som);
	        evaluation.evaluateClusterer(data);
	        System.out.println(evaluation.clusterResultsToString());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
