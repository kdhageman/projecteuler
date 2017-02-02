package solutions;

import core.Solution;
import util.Functions;

public class Problem41 implements Solution {
				
	@Override
	public int number() {
		return 0;
	}

	@Override
	public void solve() {
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
}

