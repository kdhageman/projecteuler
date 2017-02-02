package solutions;

import core.Solution;

import java.util.ArrayList;

public class Problem32 implements Solution {
	
	@Override
	public int number() {
		return 32;
	}

	@Override
	public void solve() {
		int res = 0;

		ArrayList<String> permutations = permutation("123456789");
		ArrayList<Integer> mplicands = new ArrayList<Integer>();
		ArrayList<Integer> mpliers = new ArrayList<Integer>();
		ArrayList<Integer> products = new ArrayList<Integer>();
		for (String s : permutations){ /* loop over all permutations */
			int multiplicand = Integer.parseInt(s.substring(0,2));
			int multiplier = Integer.parseInt(s.substring(2,5));
			int product = Integer.parseInt(s.substring(5,9));
			if (multiplicand*multiplier == product){ /* 2 x 3 digits = 4 digits */
				mplicands.add(multiplicand);
				mpliers.add(multiplier);
				if (!products.contains(product)){
					res += product;
				}
				products.add(product);

			}
			multiplicand = Integer.parseInt(s.substring(0,1));
			multiplier = Integer.parseInt(s.substring(1,5));
			if (multiplicand*multiplier == product){ /* 1 x 4 digits = 4 digits */
				mplicands.add(multiplicand);
				mpliers.add(multiplier);
				if (!products.contains(product)){
					res += product;
				}
				products.add(product);
			}
		}
		System.out.format("Result: %d\n", res);
	}

	public static ArrayList<String> permutation(String s){
		ArrayList<String> plist = new ArrayList<String>();
		if (s.length() == 1){ /* base case */
			plist.add(s);
		}
		else {
			char first = s.charAt(0);
			for (String n : permutation(s.substring(1))){
				for (int i=0; i<=n.length(); i++){
					plist.add(n.substring(0,  i) +first+ n.substring(i));
				}
			}
		}
		return plist;
	}
}

