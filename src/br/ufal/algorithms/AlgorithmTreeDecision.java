package br.ufal.algorithms;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

public class AlgorithmTreeDecision implements InterfaceAlgorithm {

	public AlgorithmTreeDecision() {
	}

	@Override
	public void run(String dataset) {
		try {

			// DataSource source = new DataSource("./datasets/zoo.arff");
			DataSource source = new DataSource(dataset);
			Instances data = source.getDataSet();
			// setting class attribute

			if (data.classIndex() == -1) {
				data.setClassIndex(data.numAttributes() - 1);

			}

			Instances treinametoInstances = data.trainCV(4, 2);

			

			Instances testeInstances = data.testCV(4, 2);

			

			//Remove rm = new Remove();
			//rm.setAttributeIndices("1"); // remove 1st attribute
			// classifier
			J48 j48 = new J48();
			j48.setUnpruned(true); // using an unpruned J48
			// meta-classifier
			FilteredClassifier fc = new FilteredClassifier();
			//fc.setFilter(rm);
			fc.setClassifier(j48);
			// train and make predictions
			fc.buildClassifier(treinametoInstances);			
			

			Evaluation eval = new Evaluation(data);
			eval.evaluateModel(fc, testeInstances);
			
			//eval.crossValidateModel(fc, data, 10, new Random(0));
			System.out.println(eval.toSummaryString("\nResultados Árvore de Decisão:\n======\n", false));
			
			final javax.swing.JFrame jf = 
				       new javax.swing.JFrame("Weka Classifier Tree Visualizer: J48");
				     jf.setSize(800,600);
				     jf.getContentPane().setLayout(new BorderLayout());
				     TreeVisualizer tv = new TreeVisualizer(null,
				         j48.graph(),
				         new PlaceNode2());
				     jf.getContentPane().add(tv, BorderLayout.CENTER);
				     jf.addWindowListener(new java.awt.event.WindowAdapter() {
				       public void windowClosing(java.awt.event.WindowEvent e) {
				         jf.dispose();
				       }
				     });
				 
				     jf.setVisible(true);
				     tv.fitToScreen();
				     
			System.out.println(j48);

			
			System.out.println("Instâncias de treinamento: " + treinametoInstances.numInstances());
			
			System.out.println("Instâncias de teste: " + testeInstances.numInstances());
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
