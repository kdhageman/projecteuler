package problems;

public class Problem40 { 	
				
	public Problem40(){
		int res = 1;
		int i = 1; /* integer counter */
		
		int n = 0; /* nth digit of the fractional part */
		int nLimit = 1;
		
		int d = 1; /* number of digits per number */
		int dLimit = 10; /* number where digitPerInt increases */		
		while (n < 1000000){
			if (i >= dLimit){				
				dLimit *= 10;
				d++;
			}		
			
			if (n + d >= nLimit){				
				res *= (int) (i/Math.pow(10,d-(nLimit-n)) % 10);
				nLimit *= 10;
			}		
			
			i++;
			n += d;
		}
		System.out.format("Result: %d\n", res);
	}
		 
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem40();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

