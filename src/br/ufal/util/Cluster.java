package br.ufal.util;

import java.util.ArrayList;


public class Cluster {
	

	public int id;
	public Ponto centroid;
	public ArrayList<Ponto> pontos;
	
	public Cluster(int id) {
		super();
		this.pontos = new ArrayList<Ponto>();
		this.centroid = null;
		this.id = id;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public Ponto getCentroid() {
		return centroid;
	}




	public void setCentroid(Ponto centroid) {
		this.centroid = centroid;
	}




	public ArrayList<Ponto> getPontos() {
		return pontos;
	}


	public void setPontos(ArrayList<Ponto> pontos) {
		this.pontos = pontos;
	}
	
	
	public void limparListaDePontos(){
		this.pontos.clear();
	}
	
	public void plotarPontosCluster() {
		System.out.println("[Cluster: " + id+"]");
		System.out.println("[Centróide: " + centroid + "]");
		System.out.println("[Pontos: \n");
		for(Ponto p : pontos) {
			System.out.println(p);
		}
		System.out.println("]");
	}



	@Override
	public String toString() {
		return "Cluster [id=" + id + ", centroid=" + centroid + ", pontos=" + pontos + "]";
	}

	

}
