package solutions;

import core.Solution;

public class Problem15 implements Solution {

	long[][] routes;

	@Override
	public int number() {
		return 15;
	}

	@Override
	public void solve() {
		routes = new long[21][21];
		routes[0][0] = 1;
		/* height */
		for (int j=0; j<routes[0].length; j++){
			/* width */
			for (int i=0; i<routes[0].length; i++){
				if (i != 0){
					routes[i][j] += routes[i-1][j];
				}
				if (j != 0){
					routes[i][j] += routes[i][j-1];
				}
			}
		}
		System.out.format("Result: %d\n", routes[20][20]);
	}
}
