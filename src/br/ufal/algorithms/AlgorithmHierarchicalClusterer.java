package br.ufal.algorithms;

import weka.clusterers.SimpleKMeans;
import weka.core.ChebyshevDistance;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.ManhattanDistance;
import weka.core.MinkowskiDistance;
import weka.core.SelectedTag;
import weka.core.Tag;
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
			
			data.deleteAttributeAt(0);
			data.deleteAttributeType(16);;

	        HierarchicalClusterer clusterer = new HierarchicalClusterer();
	        clusterer.setNumClusters(this.numCentroides);
	        
//	        EuclideanDistance df = new EuclideanDistance();
//			ManhattanDistance df = new ManhattanDistance();
//			ChebyshevDistance df = new ChebyshevDistance();
			MinkowskiDistance df = new MinkowskiDistance();
	        
	        clusterer.setDistanceFunction(df);
	        
	        // Tipo de link: single, complete, etc.
	        SelectedTag st = new SelectedTag(4, HierarchicalClusterer.TAGS_LINK_TYPE);
	        
	        clusterer.setLinkType(st);
	        
	        clusterer.buildClusterer(data);
	        
	        System.out.println("Função de distância: " + clusterer.getDistanceFunction().getClass().getSimpleName());
	        
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
