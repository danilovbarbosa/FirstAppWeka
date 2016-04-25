/**
 * 
 */
/**
 * @author danilo and João Paulo.
 *
 */
package br.ufal.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import br.ufal.algorithms.AlgorithmHierarchicalClusterer;
import br.ufal.algorithms.AlgorithmKMeans;
import br.ufal.algorithms.AlgorithmKMeansWeka;
import br.ufal.algorithms.AlgorithmKnn;
import br.ufal.algorithms.AlgorithmMultilayerPerceptron;
import br.ufal.algorithms.AlgorithmNetworkSom;
import br.ufal.algorithms.AlgorithmTreeDecision;
import br.ufal.util.Coordenada;
import br.ufal.util.Ponto;

public class Main {

	public static void main(String[] args) {
		String datasetARFF = "./datasets/zoo.arff";
		String datasetCSV = "./datasets/zoo.csv";
		String testCSV = "./datasets/teste.csv";

		// AlgorithmKnn instanceKnn = new AlgorithmKnn(5);
		// instanceKnn.run(datasetARFF);
		//
		// AlgorithmTreeDecision instanceTreeDecision = new
		// AlgorithmTreeDecision();
		// instanceTreeDecision.run(datasetARFF);
		//
		// AlgorithmMultilayerPerceptron instanceMLP = new
		// AlgorithmMultilayerPerceptron();
		// instanceMLP.run(datasetARFF);

		// AlgorithmKMeans instanceKkMeans = new AlgorithmKMeans(7);
		// instanceKkMeans.run(datasetCSV);

		// AlgorithmKMeansWeka kmw = new AlgorithmKMeansWeka(7);
		// kmw.run(datasetARFF);

//		 AlgorithmHierarchicalClusterer instancehC = new
//		 AlgorithmHierarchicalClusterer(7);
//		 instancehC.run(datasetARFF);

		// AlgorithmNetworkSom som = new AlgorithmNetworkSom();
		// som.run(datasetARFF);

		int total_points, total_values, K, max_iterations;
		boolean has_name;

		total_points = 101;
		total_values = 15;
		K = 7;
		max_iterations = 100;
		has_name = true;

		ArrayList<Ponto> points = new ArrayList<>();
		String point_name;

		ArrayList<Coordenada> values;
		int cont = -1;
		try {
			Reader in = new FileReader(datasetCSV);
			for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
				cont++;
				values = new ArrayList<>();

				for (String field : record) {
					if (field.equals("true")) {
						values.add(new Coordenada(1.0));
					} else if (field.equals("false")) {
						values.add(new Coordenada(0.0));
					} else if (field.length() == 1) {
						values.add(new Coordenada(Integer.parseInt(field) + 0.0));
					}
				}
				if (has_name) {
					point_name = record.getRecordNumber() + "";
					Ponto p = new Ponto(cont, values, point_name);
					points.add(p);
				} else {
					Ponto p = new Ponto(cont, values);
					points.add(p);
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		for (Ponto p1 : points) {
//			System.out.println(p1);
//		}

		 AlgorithmKMeans kmeans = new AlgorithmKMeans(K, total_values,total_points, max_iterations);
		 kmeans.run(points);

	}

}
