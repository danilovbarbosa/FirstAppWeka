package br.ufal.algorithms;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.ChebyshevDistance;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.ManhattanDistance;
import weka.core.MinkowskiDistance;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class AlgorithmKMeansWeka {

	private int numCentroides;

	public AlgorithmKMeansWeka(int numCentroides) {

		this.numCentroides = numCentroides;

	}

	public void run(String dataset) {

		try {

			DataSource source = new DataSource(dataset);
			Instances data = source.getDataSet();
			
			data.deleteAttributeAt(0);
			
			data.setClassIndex(data.numAttributes()-1);
			
			Remove filter = new Remove();
		    filter.setAttributeIndices("" + (data.classIndex() + 1));
		    filter.setInputFormat(data);
		    Instances dataClusterer = Filter.useFilter(data, filter);
			

			SimpleKMeans skm = new SimpleKMeans();

			skm.setNumClusters(numCentroides);

			skm.setPreserveInstancesOrder(true);
			
			
			
			EuclideanDistance df = new EuclideanDistance();
//			ManhattanDistance df = new ManhattanDistance();
//			ChebyshevDistance df = new ChebyshevDistance();
//			MinkowskiDistance df = new MinkowskiDistance();
			
			
			skm.setDistanceFunction(df);
			
			

			
			skm.buildClusterer(dataClusterer);

			
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
