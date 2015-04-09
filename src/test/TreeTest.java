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
		File inputFile = new File("E://workspace//WekaTest//dataFilteredTagetnew.arff");//训练语料文件
		ArffLoader atf = new ArffLoader();
		//ArffLoader atf2 = new ArffLoader();
		atf.setFile(inputFile);
		Instances instancesTrain = atf.getDataSet(); // 读入训练文件
		/*inputFile = new File("E://workspace//WekaTest//dataFiltered.arff");//测试语料文件*/		atf.setFile(inputFile);
		//File inputFile2 = new File("E://workspace//WekaTest//dataFilteredTaget1.arff");
		//atf2.setFile(inputFile2);
		//Instances instancesTest = atf2.getDataSet(); // 读入测试文件
		System.out.println("训练文件载入完成");
		
		Instances instancesTest = new Instances(new BufferedReader(new FileReader("E://workspace//WekaTest//dataFilteredTagettest.arff")));
		instancesTest.setClassIndex(0); //设置分类属性所在行号（第一行为0号），instancesTest.numAttributes()可以取得属性总数
		double sum = instancesTest.numInstances(),//测试语料实例数
				right = 0.0f;
		instancesTrain.setClassIndex(0);
		long startTime = System.currentTimeMillis();
		m_classifier.buildClassifier(instancesTrain); //训练
		long endTime = System.currentTimeMillis();
		System.out.println("训练用时" + (endTime - startTime) + "ms");
		
		System.out.println("训练完成");
		
		/*System.out.println(m_classifier.classifyInstance(instancesTest.instance(1)));*/
		
		long startTime1 = System.currentTimeMillis();
		for(int i = 0;i<sum;i++)//测试分类结果
		{
		System.out.println("分类结果：" + m_classifier.classifyInstance(instancesTest.instance(i)));
		System.out.println("原来：" + instancesTest.instance(i).classValue());
		if(m_classifier.classifyInstance(instancesTest.instance(i))==instancesTest.instance(i).classValue())// 如果预测值和答案值相等（测试语料中的分类列提供的须为正确答案，结果才有意义）
		{
		right++;//正确值加1
		}
		}
		//System.out.println("第n行：" + m_classifier.classifyInstance(instancesTest.instance(97)));
		System.out.println("NativeBayes classification precision:"+(right/sum));
		long endTime1 = System.currentTimeMillis();
		System.out.println("总数" + sum);
		System.out.println("用时" + (endTime1 - startTime1) + "ms");
	}

}
