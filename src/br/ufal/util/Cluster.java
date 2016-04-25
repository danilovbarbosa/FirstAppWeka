package br.ufal.util;

import java.util.ArrayList;

public class Cluster {
	
	private int id_cluster;
	private ArrayList<Coordenada> central_values;
	private ArrayList<Ponto> pontos;
	
	public Cluster(int id_cluster, Ponto ponto) {
		super();
		this.id_cluster = id_cluster;
		int total_values = ponto.getTotal_values();
		
		for(int i = 0; i < total_values; i++){
			central_values.add(ponto.getCoordenada(i));
		}
		System.out.println(ponto.getClass());
		pontos.add(ponto);
	}
	
	public int getId_cluster() {
		return id_cluster;
	}
	public void addPonto(Ponto ponto){
		pontos.add(ponto);
	}
	public boolean removePonto(int index){
		try{
			this.pontos.remove(index);
			return true;
		}catch(Exception e){
			System.err.println(e);
		}
		return false;
	}
	public double getCentralValue(int index){
		return central_values.get(index).getCoordenada();
	}

	public void setCentralValue(int index, double coordenada){
		central_values.get(index).setCoordenada(coordenada);
	}
	public Ponto getPonto(int index){
		return this.pontos.get(index);
	}
	public int getTotalPontos(){
		return this.pontos.size();
	}

	public ArrayList<Ponto> getPontos() {
		return pontos;
	}


}
