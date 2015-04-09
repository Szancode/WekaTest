package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
 
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.TextDirectoryLoader;
import weka.core.stemmers.NullStemmer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;
 
public class TextCategorizationTest {
  public static void main(String[] args) throws Exception {
      String filename = "E://workspace//WekaTest//test"; 
     
    // convert the directory into a dataset
    TextDirectoryLoader loader = new TextDirectoryLoader();
    loader.setDirectory(new File( filename ));
    Instances dataRaw = loader.getDataSet();
    System.out.println("\n\nImported data:\n\n" + dataRaw);
    {
    FileWriter fw = new FileWriter( "dataRawTagettest.arff" );
       BufferedWriter bw = new BufferedWriter(fw );
      
       bw.write( dataRaw.toString() );
      
       bw.close();
       fw.close();
    }
 
    StringToWordVector filter = new StringToWordVector();
    filter.setStemmer( new NullStemmer() );
    filter.setInputFormat(dataRaw);
    Instances dataFiltered = Filter.useFilter(dataRaw, filter);
    {
       FileWriter fw = new FileWriter( "dataFilteredTagettest.arff" );
       BufferedWriter bw = new BufferedWriter(fw );
      
       bw.write( dataFiltered.toString() );
      
       bw.close();
       fw.close();
    }
    System.out.println("\n\nFiltered data:\n\n" + dataFiltered);
    /*dataFiltered.setClassIndex( 0 );
 
    // train J48 and output model
    NaiveBayes classifier = new NaiveBayes();
    classifier.buildClassifier(dataFiltered);
    System.out.println("\n\nClassifier model:\n\n" + classifier);
    Evaluation eval = new Evaluation(dataFiltered);
    eval.crossValidateModel(classifier, dataFiltered, 3, new Random(1));
    System.out.println(eval.toClassDetailsString());
    System.out.println(eval.toSummaryString());
    System.out.println(eval.toMatrixString());*/
  }
}