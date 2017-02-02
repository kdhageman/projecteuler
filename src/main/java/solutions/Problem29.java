package solutions;

import core.Solution;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem29 implements Solution {

	@Override
	public int number() {
		return 29;
	}

	@Override
	public void solve() {
		int[] arange = {2, 100};
		int[] brange = {2, 100};
		ArrayList<String> l = new ArrayList<String>();
		for (int a = arange[0]; a <= arange[1]; a++){
			BigInteger abig = new BigInteger(Integer.toString(a));
			for (int b = brange[0]; b <= brange[1]; b++){
				BigInteger c = abig.pow(b);
				if (!l.contains(c.toString())){
					l.add(c.toString());
				}
			}
		}
		System.out.format("Result: %d\n", l.size());
	}
}

