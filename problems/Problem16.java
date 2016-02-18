package problems;

public class Problem16 {
	 
	public static void main(String[] args) {
		int[] digits = new int[350];
		digits[349] = 1; /* 2^0 = 1 */

		/* 1000 iterations */
		for (int c=0; c<1000; c++){			
			/* loop over all values in the digits */
			for (int i=1; i<350; i++){
				int d = digits[i]*2;
				if (d >= 10){
					digits[i] = d % 10;
					digits[i-1] += d / 10;
				}
				else {
					digits[i] = d;
				}
			}
		}
		
		int sum = 0;
		for (int i : digits) {
			sum += i;			
		}
		System.out.println(sum);		
	}	
}
