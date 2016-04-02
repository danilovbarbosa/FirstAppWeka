package br.ufal.algorithms;

public class AlgorithmKMeans {

	private void calculateCentroids() {
	        for(Cluster cluster : clusters) {
	            double sumX = 0;
	            double sumY = 0;
	            List list = cluster.getPoints();
	            int n_points = list.size();
	            
	            for(Point point : list) {
	            	sumX += point.getX();
	                sumY += point.getY();
	            }
	            
	            Point centroid = cluster.getCentroid();
	            if(n_points &gt; 0) {
	            	double newX = sumX / n_points;
	            	double newY = sumY / n_points;
	                centroid.setX(newX);
	                centroid.setY(newY);
	            }
	        }
	    }

}
