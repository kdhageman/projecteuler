package solutions;

import core.Solution;

public class Problem40 implements Solution {
				
	@Override
	public int number() {
		return 40;
	}

	@Override
	public void solve() {
		int res = 1;
		int i = 1; /* integer counter */

		int n = 0; /* nth digit of the fractional part */
		int nLimit = 1;

		int d = 1; /* number of digits per number */
		int dLimit = 10; /* number where digitPerInt increases */
		while (n < 1000000){
			if (i >= dLimit){
				dLimit *= 10;
				d++;
			}

			if (n + d >= nLimit){
				res *= (int) (i/Math.pow(10,d-(nLimit-n)) % 10);
				nLimit *= 10;
			}

			i++;
			n += d;
		}
		System.out.format("Result: %d\n", res);
	}
}

