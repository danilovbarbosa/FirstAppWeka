package br.ufal.algorithms;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
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
			
			skm.buildClusterer(data);
			
			Instances centroides = skm.getClusterCentroids();
			
			for (int i = 0; i < centroides.numInstances(); i++) { 
			      System.out.println( "Centroide " + i+1 + ": " + centroides.instance(i)); 
			 } 

			    // get cluster membership for each instance 
			 for (int i = 0; i < data.numInstances(); i++) { 
			     System.out.println( data.instance(i) + " cestá no cluster " + skm.clusterInstance(data.instance(i)) + 1); 

			 }
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
