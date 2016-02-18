package problems;

import java.math.BigInteger;

import general.Functions;

public class Problem26 {

	public Problem26(){
		int max = -1;
		int dmax = -1;
		for (int d=1000; d>=2; d--){
			if (d >= max){ /* the cycle size of 1/d can maximum be size d, so if the current maximum is already larger than d, don't even try */
				int s = Functions.recurringCycleSize(new BigInteger(Integer.toString(d)));			
				if (s > max){
					max = s;
					dmax = d;					
				}
			}
		}				
		System.out.format("Result: %d\n", dmax, max);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem26();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}
