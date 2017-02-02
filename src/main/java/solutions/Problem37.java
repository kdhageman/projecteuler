package solutions;

import core.Solution;
import util.Functions;

public class Problem37 implements Solution {

	@Override
	public int number() {
		return 37;
	}

	@Override
	public void solve() {
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
}

