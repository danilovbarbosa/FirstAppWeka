package br.ufal.util;

import java.util.ArrayList;
import java.util.Random;

public class Point {
		
	private double x = 0.0;
	private double y = 0.0;
	private int numCluster = 0;
	private Random random;
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getNumCluster() {
		return numCluster;
	}

	public void setNumCluster(int numCluster) {
		this.numCluster = numCluster;
	}
	
	//Calculo da distância euclidiana entre dois pontos.
    public double distance(Point p, Point centroid) {
        return Math.sqrt(Math.pow((centroid.getY() - p.getY()), 2) + Math.pow((centroid.getX() - p.getX()), 2));
    }
    
    //Random Points
    public Point randomPoints(int min, int max) {
    	this.random = new Random();

    	//Recebe valores de mínimo é máximo, então realiza o caluclo e retorna um novo ponto random.
    	double x = min + (max - min) * this.random.nextDouble();
    	double y = min + (max - min) * this.random.nextDouble();
    	return new Point(x,y);
		
	}
    
    public ArrayList<Point> createRandomPoints(int min, int max, int tamanhoLista) {
    	
    	ArrayList<Point> points = new ArrayList<Point>(tamanhoLista);
    	for(int i = 0; i <= tamanhoLista; i++) {
    		points.add(this.randomPoints(min,max));
    	}
    	return points;
    }
    
    
    
    
    
    
	
}
