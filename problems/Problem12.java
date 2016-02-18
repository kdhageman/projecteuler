package problems;

import general.*;

public class Problem12 {

	public Problem12(){
		int numr = 1; /* t(1)*/
		int numl;
		int i = 1;
		int maxDivisors = 0;
		while(maxDivisors <= 500){			
			numl = numr;			
			numr = Functions.numFactorize(i+1);			
			if (numl*numr > maxDivisors){
				System.out.format("t(%d) has %d divisors, which beats the previous record of %d divisors\n", i*(i+1)/2, numl*numr, maxDivisors);
				maxDivisors = numl*numr;
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem12();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}
}
