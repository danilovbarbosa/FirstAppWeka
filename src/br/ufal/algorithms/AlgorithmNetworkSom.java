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

			SelfOrganizingMap som = new SelfOrganizingMap();

			som.setConvergenceEpochs(1000);

			som.setLearningRate(0.3);
			som.setOrderingEpochs(50);

			som.setWidth(2);
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
