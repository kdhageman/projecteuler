package solutions;

import core.Solution;

public class Problem33 implements Solution {
	
	@Override
	public int number() {
		return 0;
	}

	@Override
	public void solve() {
		for (int n=10; n<=98; n++){ /* 10 <= numerator <= 98 */
			int n1 = n/10;
			int n2 = n%10;
			for (int d=n+1; d<= 99; d++){
				int d1 = d/10;
				int d2 = d%10;

				if (n1 != d1 && n1 != d2 && n2 != d1 && n2 != d1) continue; /* check if n and d share a digit */
				if (n2 == 0 && d2 == 0) continue; /* check if n and d share a non-trivial digit */
				/* check if fraction is changed after removing shared digit */
				if (n1 == d1 && (float) n/d == (float) n2/d2){ /* n/d == n2/d2 ?*/
					System.out.format("n=%d%d and d=%d%d = %f\n", n1, n2, d1, d2);
				}
				else if (n1 == d2 && (float) n/d == (float) n2/d1){ /* n/d == n2/d1 ?*/
					System.out.format("n=%d%d and d=%d%d = %f\n", n1, n2, d1, d2);
				}
				else if (n2 == d1 && (float) n/d == (float) n1/d2){ /* n/d == n1/d2 ?*/
					System.out.format("n=%d%d and d=%d%d\n", n1, n2, d1, d2);
				}
				else if (n2 == d2 && (float) n/d == (float) n1/d1){ /* n/d == n1/d1 ?*/
					System.out.format("n=%d%d and d=%d%d\n", n1, n2, d1, d2);
				}
			}
		}
	}
}

