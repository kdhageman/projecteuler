package problems;

import java.util.Arrays;

import general.Functions;

public class Problem41 { 	
				
	public Problem41(){		
		int res = 0;		
		for (int i=9; i>1; i--){ /* largest possible pandigital number has 9 digits */			
			/* create pandigital number n of size i */
			int n=0;
			for (int j=i; j>0; j--){
				n += j*Math.pow(10, j-1);
			}			
						
			while (n > -1){ /* loop over all permutation of n */
				if (Functions.consideredPrime(n) && Functions.isPrime(n)){ /* check for primality */
					res = n;
					break;
				}				
				n = Functions.nextPermutation(n, true);
			}
			
			if (res > 0){
				break;
			}
		}
		System.out.format("Result: %d\n", res);
	}
		 
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem41();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

