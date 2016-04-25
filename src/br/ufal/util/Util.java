package br.ufal.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Util {
	
	ArrayList<Ponto> points = new ArrayList<>();


	public ArrayList<Ponto> lerDataset(String caminhoArquivo) throws FileNotFoundException {

		Ponto auxP;
		try {
			int cont = 0;
			Reader in = new FileReader(caminhoArquivo);
			for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
				
				
				auxP = new Ponto(++cont, "");
				for (String field : record) {
					// System.out.print(" " + field + ",");
					if (field.equals("true")) {
						auxP.addValues(new Coordenada(1.0));
					} else if (field.equals("false")) {
						auxP.addValues(new Coordenada(0.0));
					} else if (field.length() == 1) {
						auxP.addValues(new Coordenada(Integer.parseInt(field) + 0.0));
					}
				}
				// System.out.println(auxP);
				this.points.add(auxP);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.points;

	}

}
