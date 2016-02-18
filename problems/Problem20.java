package problems;

import java.util.HashMap;
import java.util.LinkedList;

import general.Functions;

public class Problem20 {

	public static void main(String[] args) {
		LinkedList<Long> l = new LinkedList<Long>();
		l.add((long) 1);
		for(int i=1; i<=100; i++){
			l = mult(l,i);
		}
		System.out.println(l);	
		
		long s = 0;
		for (Long e : l){
			s += e; 
		}
		System.out.println(s);
	}
	
	public static LinkedList<Long> mult(LinkedList<Long> l, int n){
		for(int i=0; i<l.size(); i++){
			l.set(i, l.get(i)*n);
		}
		return fixList(l);
	}
	
	/* makes sure that the list only contains values smaller than 10 */
	public static LinkedList<Long> fixList(LinkedList<Long> l){
		long c = l.get(0);
		if (c >= 10){
			l.set(0, c % 10);
			l.addFirst(c / 10);
			l = fixList(l);
		}
		for (int i=1; i<l.size(); i++){
			c = l.get(i);
			if (c >= 10){
				l.set(i, c % 10);
				l.set(i-1, l.get(i-1) + (c / 10));
				l = fixList(l);
			}
		}
		return l;
	}
	
	public static HashMap<Integer, Integer> mergeHashMaps(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b){
		for (Integer key : b.keySet()) {
			if (a.containsKey(key)){
				a.put(key, a.get(key)+b.get(key));
			}
			else {
				a.put(key, b.get(key));
			}
		}
		return a;
	}
	
	public static void old(){
		HashMap<Integer, Integer> divs = new HashMap<Integer, Integer>();
		for (int i=1; i<=100; i++){
			HashMap<Integer, Integer> newMap = Functions.factorize(i);
			divs = mergeHashMaps(divs, newMap);
		}
		System.out.println(divs);
		
		/* find out which divisors multiplied are divisible by 10 */
		for (Integer key1 : divs.keySet()) {
			for (Integer key2 : divs.keySet()) {
				if (key1*key2 % 10 == 0){
					System.out.format("%d * %d %% 10 == 0\n", key1, key2);
				}
			}
		}
		
		/* remove as many combination of 5*2 from the hashtable */
		int minVal = Math.min(divs.get(2), divs.get(5));
		if (divs.get(2) == minVal){
			divs.remove(2);
			divs.put(5, divs.get(5)-minVal);
		}
		else{
			divs.remove(5);
			divs.put(2, divs.get(2)-minVal);
		}
		System.out.println(divs);	
	}	
}
