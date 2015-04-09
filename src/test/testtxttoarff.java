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
import weka.core.converters.TextDirectoryLoader;
import weka.core.stemmers.NullStemmer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

public class testtxttoarff {

	/*public void segmentFile( String sourceFile, String targetFile ) {
	       try {
	           FileReader fr = new FileReader( sourceFile );
	           BufferedReader br = new BufferedReader(fr);
	   
	           FileWriter fw = new FileWriter( targetFile );
	           BufferedWriter bw = new BufferedWriter(fw );
	           
	           IKSegmenter ik = new IKSegmenter(br,true);
	           Lexeme lex = null;
	           while((lex=ik.next())!=null)
	           {
	        	   bw.write(lex.getLexemeText());
	        	   bw.write(' ');
	           }
	          
	           Analyzer analyzer = new IKAnalyzer(true); 
	           TokenStream tokenStream = analyzer.tokenStream("", br );
	           TermAttribute termAtt = (TermAttribute) tokenStream
	                  .getAttribute(TermAttribute.class);
	 
	           while (tokenStream.incrementToken()) {
	              bw.write( termAtt.term() );
	              bw.write(' ');
	           }
	 
	           bw.close();
	           fw.close();
	       } catch( IOException e ) {
	           e.printStackTrace();
	       }
	    }*/
	
	public static void main(String[] args) throws Exception {
		
		String sourceFile = "8_18.txt";
		String targetFile = "8_18.arff";
		String tel ="@relation E__workspace_WekaTest_Taget";
		String next = "\r";
		String str = "@attribute text string";
		String cla = "@attribute @@class@@ {1,2,3}";
		String dat = "@data";
		String sss = "'";
		
		try {
	           FileReader fr = new FileReader( sourceFile );
	           BufferedReader br = new BufferedReader(fr);
	   
	           FileWriter fw = new FileWriter( targetFile );
	           BufferedWriter bw = new BufferedWriter(fw );
	           bw.write(tel+next);
	           bw.write(next);
	           bw.write(str+next);
	           bw.write(cla+next);
	           bw.write(next);
	           bw.write(dat+next);
	           bw.write(sss);
	           
	           
	           IKSegmenter ik = new IKSegmenter(br,true);
	           Lexeme lex = null;
	           while((lex=ik.next())!=null)
	           {
	        	   bw.write(lex.getLexemeText());
	        	   bw.write(' ');
	           }
	           //bw.write('\r');
	           bw.write(sss);
	           bw.write(',');
	           bw.write('1');
	         
	           bw.close();
	           fw.close();
	       } catch( IOException e ) {
	           e.printStackTrace();
	       }
	}
    	
}
