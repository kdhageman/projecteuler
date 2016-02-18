package problems;

import general.LargeInt;

public class Problem25 {

	public static void main(String[] args) {
		LargeInt fold = new LargeInt(1);
		LargeInt fnew = new LargeInt(1);
		System.out.format("f(1) = %s\n", fold.toString());
		System.out.format("f(2) = %s\n", fnew.toString());
		LargeInt tmp;
		
		int i = 2;
		
		int curr_digits = fnew.digits();
		int max_digits = curr_digits;
		
		while (curr_digits < 10000){
			tmp = fnew.copy();
			fnew.add(fold);			
			fold = tmp;
			i++;
			
			curr_digits = fnew.digits();
			if (curr_digits > max_digits){
				max_digits = curr_digits;
				System.out.format("f(%d).digits() = %d\n", i, max_digits);
			}
		}		
	}
}
