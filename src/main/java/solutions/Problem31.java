package solutions;

import core.Solution;

public class Problem31 implements Solution {

	int[] coins = {2, 5, 10, 20, 50, 100, 200};

	@Override
	public int number() {
		return 31;
	}

	@Override
	public void solve() {
		System.out.format("Result: %d\n", p(200, 200, 0));
	}

	/* find number of ways to divide 'n' one-pennies */
	public int p(int n, int max, int depth){
		int res = 1;

		for (int c : coins){ /* try every coin type, as long as its not larger than our defined max */
			if (c <= n && c <= max){
				res += p(n-c, c, depth+1);
			}
		}
		return res;
	}
}

