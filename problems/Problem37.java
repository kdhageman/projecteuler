package problems;

import general.Functions;

public class Problem37 { 	
	
	public Problem37(){
		int nrPrimes = 0;
		int res = 0;
		int n=11;
		
		while (nrPrimes < 11){
			if (Functions.isTruncatablePrime(n)){				
				nrPrimes ++;
				res += n;
				System.out.format("%d is truncatable (%d/11)\n", n, nrPrimes);
			}
			n++;
		}		
		System.out.format("Result: %d\n", res);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem37();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

