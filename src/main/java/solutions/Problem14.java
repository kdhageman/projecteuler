package solutions;

import core.Solution;

public class Problem14 implements Solution {

	@Override
	public int number() {
		return 14;
	}

	@Override
	public void solve() {
		int l = 0; /* longest chain */
		for (int i=1; i<=1000000; i++){
			int c = 0; /* current chain length */
			long n = i; /* current collatz number */
			while (n != 1){
				n = (n % 2 == 0 ? n/2 : 3*n + 1);
				c++;
			}
			if (c > l){
				l = c;
				System.out.format("chain increased to %d (for i=%d)\n", l, i);
			}
		}
	}
}
