package problems;

import general.Functions;

public class Problem36 { 	
	
	public Problem36(){
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
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem36();
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

