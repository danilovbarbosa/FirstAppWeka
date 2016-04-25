package br.ufal.util;

import java.util.ArrayList;

public class Ponto {
	
	
	private int id_point, id_cluster, total_values;
	ArrayList<Coordenada> values;
	private String name;
	
	public Ponto(int id_point, ArrayList<Coordenada> values, String name) {
		super();
		this.id_point = id_point;
		this.total_values = values.size();
		this.values = values;
		this.name = name;
		this.id_cluster = -1;
	}
	
	public Ponto(int id_point, ArrayList<Coordenada> values) {
		super();
		this.id_point = id_point;
		this.total_values = values.size();
		this.values = values;
		this.id_cluster = -1;
	}
	
	public Ponto(int id_point, String name) {
		super();
		this.id_point = id_point;
		this.total_values = values.size();
		this.id_cluster = -1;
	}
	public int getId_point() {
		return id_point;
	}

	public int getId_cluster() {
		return id_cluster;
	}
	public void setId_cluster(int id_cluster) {
		this.id_cluster = id_cluster;
	}
	public int getTotal_values() {
		return total_values;
	}
	public Coordenada getCoordenada(int index) {
		return values.get(index);
	}
	public double getValue(int index) {
		return values.get(index).getCoordenada();
	}
	public ArrayList<Coordenada> getValues() {
		return values;
	}
	public void addValues(Coordenada coordenada) {
		this.values.add(coordenada);
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Ponto [id_point=" + id_point + ", id_cluster=" + id_cluster + ", total_values=" + total_values
				+ ", values=" + values + ", name=" + name + "]";
	}
	

}
