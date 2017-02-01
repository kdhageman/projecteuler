package problems;

import general.Functions;

public class Problem43 { 	
	
	/**
	 * Brute-forcing all possible 0-9 pandigital numbers. 
	 * The solutions uses pandigital numbers as Strings, since it makes it possible to have integers starting with 0.
	 * Additionally, gettting substring from the numbers is trivial with Strings.   
	 */
	public Problem43(){
		long res = 0;
				
		String n = "0123456789";	
		while (n != null){
			boolean p1 = Integer.parseInt(n.substring(1, 4)) % 2 == 0;						
			boolean p2 = Integer.parseInt(n.substring(2, 5)) % 3 == 0;
			boolean p3 = Integer.parseInt(n.substring(3, 6)) % 5 == 0;
			boolean p4 = Integer.parseInt(n.substring(4, 7)) % 7 == 0;
			boolean p5 = Integer.parseInt(n.substring(5, 8)) % 11 == 0;
			boolean p6 = Integer.parseInt(n.substring(6, 9)) % 13 == 0;
			boolean p7 = Integer.parseInt(n.substring(7, 10)) % 17 == 0;
			
			if (p1 && p2 && p3 && p4 && p5 && p6 && p7){				
				res += Long.parseLong(n);				
			}
			
			n = Functions.nextPermutation(n, false);			
		}
		System.out.format("Result: %d\n", res);
	}
		 
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem43();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

