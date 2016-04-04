package br.ufal.util;

import java.util.ArrayList;

public class Cluster {
	

	public int id;
	public Point centroid;
	public ArrayList<Point> points;
	
	public Cluster(int id) {
		super();
		this.points = new ArrayList<>();
		this.centroid = null;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Point getCentroid() {
		return centroid;
	}

	public void setCentroid(Point centroid) {
		this.centroid = centroid;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Cluster [id=" + id + ", centroid=" + centroid + ", points=" + points + "]";
	}

	

}
