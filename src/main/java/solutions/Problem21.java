package problems;

import general.Functions;

public class Problem21 {

	public Problem21(){
		int s = 0;		
		for (int i=1; i<=10000; i++){ /* 1 to 10000 */
			int pdivi = Functions.sumProperDiv(i);
			if (pdivi < 10000 && pdivi != i && Functions.sumProperDiv(pdivi) == i){ /* i and pdivi are an amicable pair */								
				s += pdivi;
			}
		}
		System.out.format("Result: %d\n", s);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem21();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}
}
