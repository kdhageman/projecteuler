package problems;

import general.LargeInt;

public class Problem25 {

	public Problem25(){
		LargeInt fold = new LargeInt(1);
		LargeInt fnew = new LargeInt(1);		
		LargeInt tmp;
		
		int i = 2;
		
		int curr_digits = fnew.digits();
		int max_digits = curr_digits;
		
		while (curr_digits < 1000){
			tmp = fnew.copy();
			fnew.add(fold);			
			fold = tmp;
			i++;
			
			curr_digits = fnew.digits();
			if (curr_digits > max_digits){
				max_digits = curr_digits;				
			}
		}	
		System.out.format("Result: %d\n", i);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem25();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}
}
