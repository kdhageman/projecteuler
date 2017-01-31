package solutions;

import core.Solution;
import util.Functions;

public class Problem36 implements Solution {

	@Override
	public int number() {
		return 36;
	}

	@Override
	public void solve() {
		int res = 0;
		for (int n=0; n<1000000; n++){
			String nDecimal = Integer.toString(n); /* check if decimal is palindrome */
			String nBinary = Integer.toBinaryString(n); /* check if binary is palindrome */
			if (Functions.isPalindrome(nDecimal) && Functions.isPalindrome(nBinary)){
				System.out.format("d(%s) and b(%s) are palindromic\n", nDecimal, nBinary);
				res += n;
			}
		}
		System.out.format("Result: %d\n", res);
	}
}

