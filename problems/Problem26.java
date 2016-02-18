package problems;

import java.math.BigInteger;

import general.Functions;

public class Problem26 {

	public static void main(String[] args) {
		int max = -1;
		int dmax = -1;
		for (int d=1000; d>=2; d--){
			if (d >= max){ /* the cycle size of 1/d can maximum be size d, so if the current maximum is already larger than d, don't even try */
				int s = Functions.recurringCycleSize(new BigInteger(Integer.toString(d)));			
				if (s > max){
					max = s;
					dmax = d;
					System.out.format("%d for d=%d\n", s, d);
				}
			}
		}				
		System.out.format("Final results for d=%d: %d\n", dmax, max);
//		System.out.println(Functions.recurringCycleSize(new BigInteger("7")));
	}	
}
