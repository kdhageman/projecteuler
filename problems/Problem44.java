package problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import general.Functions;

public class Problem44 { 	
		
	public Problem44(){
		long res = 0;
		TreeSet<Integer> p_neg = new TreeSet<Integer>(); /* set used to compute p_k - p_j */
		TreeSet<Integer> p_pos = new TreeSet<Integer>(); /* set used to compute p_k + p_j */
		int n = 1;		
		while (n < 20){
			int p_n = n*(3*n - 1)/2; 
			int d_n = p_neg.isEmpty()? p_n : p_n - p_neg.last(); /* distance between last two elements */
			
			
			Iterator<Integer> it = p_pos.iterator();
			while(it.hasNext()){
				int i = it.next();			
			
				if (i <= d_n){				
					it.remove();
				}
			}
			
			System.out.format("p_n=%s, d_n=%d\np_neg: %s\np_pos: %s\n\n", p_n, d_n, p_neg, p_pos);
			
			p_neg.add(p_n);
			p_pos.add(p_n);
			n++;
		}
		
		System.out.format("Result: %d\n", res);
	}
		 
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem44();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

