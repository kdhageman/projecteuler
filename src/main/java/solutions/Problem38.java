package solutions;

import core.Solution;

public class Problem38 implements Solution {

	@Override
	public int number() {
		return 0;
	}

	@Override
	public void solve() {
		int pBest = 0;
		int maxTriangles = 0;
		for (int p=3; p<=1000; p++){
			int numTriangles = 0;
			for (int a=1; a<=Math.ceil(p/2)-1; a++){
				for (int b=1; b<p-2*a; b++){
					int c = p - a - b;
					if (c == Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))){
						numTriangles++;
					}
				}
			}
			numTriangles /= 2;
			if (numTriangles > maxTriangles){
				maxTriangles = numTriangles;
				pBest = p;
			}
		}
		System.out.format("Result p(%d): %d\n", pBest, maxTriangles);
	}
}

