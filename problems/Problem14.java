package problems;

import java.util.ArrayList;

public class Problem14 {

	public static class lrcResponse{
		public int chainlength;
		public int value;
		
		public lrcResponse(int c, int v){
			chainlength = c;
			value = v;
		}
	}
	
	public static void main(String[] args) {
//		for (int i=1; i<=100; i++){
//			System.out.println(normal(i));
//		}
		normal();
	}
	
	public static void reverse(){
		int n = 1;
		int c = 0;		
		while (c < 100){
			System.out.format("%d\n", n);
			if ((n-1) % 3 == 0 && n % 2 == 0 && (n-1)/3 != 1 && (n-1)/3 != 0){
				n = (n-1)/3;
			}
			else{
				n = 2*n;
			}			
			c++;
		}	
	}
	
	/* returns the longest chain for n as ending node */
	public static lrcResponse longestReverseChain(int n){
			
		/* if n is larger than 1 million, stop the chain */
		if (2*n > 100000){
			return new lrcResponse(1, n);
		}
		
		lrcResponse result = longestReverseChain(2*n);	
		/* has an odd 'parent' node that fulfills the requirements */
		if ((n-1) % 3 == 0 && n % 2 == 0 && (n-1)/3 != 1 && (n-1)/3 != 0){
			lrcResponse oddParent = longestReverseChain((n-1)/3);
			if (oddParent.chainlength > result.chainlength){
				result = oddParent;
			}			
		}
		result.chainlength++;
		return result;
	}
	
	public static ArrayList<Integer> normal(int n){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(n);
		while (n != 1){
			n = (n % 2 == 0 ? n/2 : 3*n+1);
			list.add(n);
		}
		return list;
	}
	
	public static void normal(){
		int l = 0; /* longest chain */
		for (int i=1; i<=1000000; i++){			
			int c = 0; /* current chain length */
			long n = i; /* current collatz number */
			while (n != 1){
				n = (n % 2 == 0 ? n/2 : 3*n + 1);
				c++;			
			}
			if (c > l){
				l = c;
				System.out.format("\nchain increased to %d (for i=%d)\n", l, i);
			}
		}		
	}
}
