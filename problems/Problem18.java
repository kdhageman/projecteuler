package problems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import general.TreeRow;

public class Problem18 {
	
	public static void main(String[] args) {
		TreeRow t = generateTree("C:/Users/Kaspar/Workspace/Project Euler/src/inputfiles/Problem18");		
		System.out.println(t.maxTotal(0));
	}
	
	public static TreeRow generateTree(String fn){
		TreeRow r = null;        
        String line = null;
        
        try {
            FileReader fr 		= new FileReader(fn);
            BufferedReader br 	= new BufferedReader(fr);

            while((line = br.readLine()) != null) {
            	String[] elementsString = line.split(" ");
            	int[] elements = new int[elementsString.length];
            	for (int i=0; i<elementsString.length; i++){
            		elements[i] = Integer.parseInt(elementsString[i]); 
            	}
            	TreeRow newRow = new TreeRow();
            	newRow.values = elements;
                
                if (r == null){
                	r = newRow;
                }
                else{
                	r.getLeaf().child = newRow;
                }
            }  
            
            br.close();         
        }
        catch(FileNotFoundException ex) {
        	ex.printStackTrace();                
        }
        catch(IOException ex) {
        	ex.printStackTrace();
        }
		return r;
	}
	
}
