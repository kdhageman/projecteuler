package solutions;

import core.Solution;
import util.Functions;

public class Problem12 implements Solution {

	@Override
	public int number() {
		return 12;
	}

	@Override
	public void solve() {
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
}
