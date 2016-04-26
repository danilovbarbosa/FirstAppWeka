package br.ufal.algorithms;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.ChebyshevDistance;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.ManhattanDistance;
import weka.core.MinkowskiDistance;
import weka.core.converters.ConverterUtils.DataSource;

public class AlgorithmKMeansWeka {

	private int numCentroides;

	public AlgorithmKMeansWeka(int numCentroides) {

		this.numCentroides = numCentroides;

	}

	public void run(String dataset) {

		try {

			DataSource source = new DataSource(dataset);
			Instances data = source.getDataSet();

			SimpleKMeans skm = new SimpleKMeans();

			skm.setNumClusters(numCentroides);

			skm.setPreserveInstancesOrder(true);
			
			EuclideanDistance df = new EuclideanDistance();
//			ManhattanDistance df = new ManhattanDistance();
//			ChebyshevDistance df = new ChebyshevDistance();
//			MinkowskiDistance df = new MinkowskiDistance();
			
			
			skm.setDistanceFunction(df);
			
			

			skm.buildClusterer(data);

			
			ClusterEvaluation evaluation = new ClusterEvaluation();
	        evaluation.setClusterer(skm);
	        evaluation.evaluateClusterer(data);
	        
	        System.out.println("Função de distância: " + skm.getDistanceFunction().getClass().getSimpleName());
	        
	        System.out.println(evaluation.clusterResultsToString());


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
