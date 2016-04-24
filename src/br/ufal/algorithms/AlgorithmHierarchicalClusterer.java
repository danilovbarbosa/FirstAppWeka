package br.ufal.algorithms;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.HierarchicalClusterer;


public class AlgorithmHierarchicalClusterer implements InterfaceAlgorithm {

	private int numCentroides;

	public AlgorithmHierarchicalClusterer(int numCentroides) {

		this.numCentroides = numCentroides;

	}

	@Override
	public void run(String dataset) {
		try {

			DataSource source = new DataSource(dataset);
			Instances data = source.getDataSet();

	        HierarchicalClusterer clusterer = new HierarchicalClusterer();
	        clusterer.setNumClusters(this.numCentroides);

	        clusterer.buildClusterer(data);
	        ClusterEvaluation evaluation = new ClusterEvaluation();
	        evaluation.setClusterer(clusterer);
	        evaluation.evaluateClusterer(data);
	        System.out.println(evaluation.clusterResultsToString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
