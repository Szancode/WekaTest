package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
//import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.NaiveBayesMultinomial;

public class TreeTest {
	
	public static void main(String[] args) throws Exception {
		//Classifier m_classifier = new NaiveBayes();
		Classifier m_classifier = new NaiveBayesMultinomial();
		File inputFile = new File("E://workspace//WekaTest//dataFilteredTagetnew.arff");//ѵ�������ļ�
		ArffLoader atf = new ArffLoader();
		//ArffLoader atf2 = new ArffLoader();
		atf.setFile(inputFile);
		Instances instancesTrain = atf.getDataSet(); // ����ѵ���ļ�
		/*inputFile = new File("E://workspace//WekaTest//dataFiltered.arff");//���������ļ�*/		atf.setFile(inputFile);
		//File inputFile2 = new File("E://workspace//WekaTest//dataFilteredTaget1.arff");
		//atf2.setFile(inputFile2);
		//Instances instancesTest = atf2.getDataSet(); // ��������ļ�
		System.out.println("ѵ���ļ��������");
		
		Instances instancesTest = new Instances(new BufferedReader(new FileReader("E://workspace//WekaTest//dataFilteredTagettest.arff")));
		instancesTest.setClassIndex(0); //���÷������������кţ���һ��Ϊ0�ţ���instancesTest.numAttributes()����ȡ����������
		double sum = instancesTest.numInstances(),//��������ʵ����
				right = 0.0f;
		instancesTrain.setClassIndex(0);
		long startTime = System.currentTimeMillis();
		m_classifier.buildClassifier(instancesTrain); //ѵ��
		long endTime = System.currentTimeMillis();
		System.out.println("ѵ����ʱ" + (endTime - startTime) + "ms");
		
		System.out.println("ѵ�����");
		
		/*System.out.println(m_classifier.classifyInstance(instancesTest.instance(1)));*/
		
		long startTime1 = System.currentTimeMillis();
		for(int i = 0;i<sum;i++)//���Է�����
		{
		System.out.println("��������" + m_classifier.classifyInstance(instancesTest.instance(i)));
		System.out.println("ԭ����" + instancesTest.instance(i).classValue());
		if(m_classifier.classifyInstance(instancesTest.instance(i))==instancesTest.instance(i).classValue())// ���Ԥ��ֵ�ʹ�ֵ��ȣ����������еķ������ṩ����Ϊ��ȷ�𰸣�����������壩
		{
		right++;//��ȷֵ��1
		}
		}
		//System.out.println("��n�У�" + m_classifier.classifyInstance(instancesTest.instance(97)));
		System.out.println("NativeBayes classification precision:"+(right/sum));
		long endTime1 = System.currentTimeMillis();
		System.out.println("����" + sum);
		System.out.println("��ʱ" + (endTime1 - startTime1) + "ms");
	}

}
