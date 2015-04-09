package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.stemmers.NullStemmer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class Stringtext {
	

	
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		//File inputFile = new File("E://workspace//WekaTest//100.arff");
		//ArffLoader atf = new ArffLoader();
		//atf.setFile(inputFile);
		Instances instancesString = new Instances(new BufferedReader(new FileReader("E://workspace//WekaTest//8_18.arff")));
		StringToWordVector filter = new StringToWordVector();
	    filter.setStemmer( new NullStemmer() );
	    filter.setInputFormat(instancesString);
	    Instances dataFiltered = Filter.useFilter(instancesString, filter);
	    {
	       FileWriter fw = new FileWriter( "Taget.arff" );
	       BufferedWriter bw = new BufferedWriter(fw );
	      
	       bw.write( dataFiltered.toString() );
	      
	       bw.close();
	       fw.close();
	    }
		
	}
}
