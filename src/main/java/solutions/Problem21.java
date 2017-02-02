package solutions;

import core.Solution;
import util.Functions;

public class Problem21 implements Solution {

	@Override
	public int number() {
		return 21;
	}

	@Override
	public void solve() {
		int s = 0;
		for (int i=1; i<=10000; i++){ /* 1 to 10000 */
			int pdivi = Functions.sumProperDiv(i);
			if (pdivi < 10000 && pdivi != i && Functions.sumProperDiv(pdivi) == i){ /* i and pdivi are an amicable pair */
				s += pdivi;
			}
		}
		System.out.format("Result: %d\n", s);
	}
}
