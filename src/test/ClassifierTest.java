package test;

import java.io.FileReader;

import weka.classifiers.trees.J48;
import weka.core.Instances;

public class ClassifierTest 

{

	 private Instances m_instances = null;
	   
	    public void getFileInstances( String fileName ) throws Exception
	    {
	        FileReader frData = new FileReader( fileName );
	        m_instances = new Instances( frData );
	       
	        m_instances.setClassIndex( m_instances.numAttributes() - 1 );
	    }
	   
	    public void classify() throws Exception
	    {
	        J48 classifier = new J48();
	        //NaiveBayes classifier = new NaiveBayes();
	        //SMO classifier = new SMO();
	       
	        classifier.buildClassifier( m_instances );
	        System.out.println( classifier.classifyInstance( m_instances.instance( 0 ) ) );
	    }
	   
	    public static void main( String[] args ) throws Exception
	    {
	        ClassifierTest ctest = new ClassifierTest();
	       
	        ctest.getFileInstances( "E://Program Files//Weka-3-6//data//contact-lenses.arff");
	        ctest.classify();
	    }
}
