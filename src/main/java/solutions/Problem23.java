package solutions;

import java.util.ArrayList;

import core.Solution;
import util.Functions;

public class Problem23 implements Solution {

	@Override
	public int number() {
		return 23;
	}

	@Override
	public void solve() {
		ArrayList<Integer> an = new ArrayList<>(); /* abundant numbers */
		/* All abundant numbers below our threshold */
		for (int i=1; i<=28123; i++){
			if (Functions.isAbundant(i)){
				an.add(i);
			}
		}
		System.out.println(an.size());

		ArrayList<Integer> san = new ArrayList<>(); /* sum of two abundant numbers */

		/* All sums of abundant numbers */
		for (int i=0; i<an.size(); i++){
			for (int j=i; j<an.size(); j++){
				if (an.get(i)+an.get(j) <= 28123) san.add(an.get(i)+an.get(j));
			}
		}
		System.out.println(san.size());

		/* Sum all numbers below 28124 that are not a sum of two abundant numbers */
		int s =0;
		for (int i=1; i<= 28123; i++){
			if (i % 2812 == 0){
				System.out.format(".");
			}
			if (!san.contains(i)){
				s += i;
			}
		}
		System.out.format("\nResult: %d\n", s);
	}
}
