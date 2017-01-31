package problems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Problem22 {

	public Problem22(){
		TreeSet<String> set = loadNames("C:/Users/Kaspar/Workspace/Project Euler/src/inputfiles/Problem22");
		long sum = 0;
		int setIndex = 1;
		for (String s : set){		
			sum += setIndex * getNameScore(s);
			setIndex ++;
		}
		System.out.format("Result: %d\n", sum);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem22();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}
	
	public static int getNameScore(String name){
		int r=0;
		for(char c : name.toCharArray()){
			r += getCharScore(c);
		}
		return r;
	}
	
	public static int getCharScore(char c){
		return Character.getNumericValue(c)- 9;		
	}
	
	public static TreeSet<String> loadNames(String fn){
		TreeSet<String> names = new TreeSet<String>();

		try {	        
            FileReader fr 		= new FileReader(fn);
            BufferedReader br 	= new BufferedReader(fr);

            String line = br.readLine();
            String[] lineSplitted = line.split(",");
            for (String s : lineSplitted){
            	names.add(s.replace("\"", "").toLowerCase());
            }            
            br.close();         
        }
        catch(FileNotFoundException ex) {
        	ex.printStackTrace();                
        }
        catch(IOException ex) {
        	ex.printStackTrace();
        }
		return names;
	}

}
