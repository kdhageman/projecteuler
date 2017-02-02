package solutions;

import core.Solution;

public class Problem34 implements Solution {
	
	public int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	
	@Override
	public int number() {
		return 0;
	}

	@Override
	public void solve() {
		int res = 0;
		for (int i=3; i<=2540160; i++){ /* loop until 7*9! (the upper bound) */

			int sum = 0;
			int n = i;
			while (n != 0){ /* loop from least-significant to most-significant digit by dividing (and flooring) the value until it reaches 0 (becomes a fraction lower than 1) */
				sum += factorials[(n % 10)];
				n /= 10;
			}
			if (sum == i){
				res += i;
				System.out.format("Sum of factorials equals i=%d\n", i);
			}
		}
		System.out.format("Result: %d\n", res);
	}
}

