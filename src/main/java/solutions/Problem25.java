package solutions;

import core.Solution;
import util.LargeInt;

public class Problem25 implements Solution {

	@Override
	public int number() {
		return 25;
	}

	@Override
	public void solve() {
		LargeInt fold = new LargeInt(1);
		LargeInt fnew = new LargeInt(1);
		LargeInt tmp;

		int i = 2;

		int curr_digits = fnew.digits();
		int max_digits = curr_digits;

		while (curr_digits < 1000){
			tmp = fnew.copy();
			fnew.add(fold);
			fold = tmp;
			i++;

			curr_digits = fnew.digits();
			if (curr_digits > max_digits){
				max_digits = curr_digits;
			}
		}
		System.out.format("Result: %d\n", i);
	}
}
