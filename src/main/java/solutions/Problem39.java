package solutions;

import core.Solution;
import util.Functions;

public class Problem39 implements Solution {
		
	@Override
	public int number() {
		return 39;
	}

	@Override
	public void solve() {
		int res = 0;
		/* n=2 */
		for (int i=9400; i>=9000; i--){
			int d1 = i;
			int d2 = i*2;
			String s = Integer.toString(d1) + Integer.toString(d2);
			if (Functions.isPandigital(s)){
				System.out.format("n=2 a=%d -> %s\n", i, s);
				if (Integer.parseInt(s) > res){
					res = Integer.parseInt(s);
				}
			}
		}
		System.out.format("Result: %d\n", res);
	}
}

