package problems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

import general.Functions;

public class Problem42 { 	
				
	public Problem42(){		
		TreeSet<String> words = loadWords("C:/Users/Kaspar/Workspace/Project Euler/src/inputfiles/Problem42");
		int res = 0; /* number of triangle words */
		for (String w : words){ /* per words */
			int wordValue = 0;
			for (int i=0; i<w.length(); i++){ /* per character */
				wordValue += (int) w.charAt(i) - 96;
			}			
			if (Functions.isTriangle(wordValue) != 0){
				res++;
			}			
		}		 
		System.out.format("Result: %d\n", res);
	}
		 
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem42();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
	
	/**
	 * Reads all words from a file using the comma delimiter.  
	 * @param fn the filename that should be read.
	 * @return a set of all read words.
	 */
	public static TreeSet<String> loadWords(String fn){
		TreeSet<String> words = new TreeSet<String>();

		try {	        
            FileReader fr 		= new FileReader(fn);
            BufferedReader br 	= new BufferedReader(fr);

            String line = br.readLine();
            String[] lineSplitted = line.split(",");
            for (String s : lineSplitted){
            	words.add(s.replace("\"", "").toLowerCase());
            }            
            br.close();         
        }
        catch(FileNotFoundException ex) {
        	ex.printStackTrace();                
        }
        catch(IOException ex) {
        	ex.printStackTrace();
        }
		return words;
	}
}

