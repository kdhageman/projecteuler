package problems;

import java.util.ArrayList;

import general.Functions;

public class Problem27 {

	public static void solveProblem(){
		int nmax = -1;
		int amax = -1;
		int bmax = -1;
		ArrayList<Integer> primes = new ArrayList<>(); /* keeps track of all primes already encountered */
		for (int a=-999; a<1000; a++){
			for (int b=-999; b<1000; b++){				
				int n=0;
				boolean still_prime = true;
				while(still_prime){					
					int val = ((int) Math.pow(n, 2)) + (a*n) + b;
					if (n > 1)
						System.out.format("Trying a=%d and b=%d, n=%d: %d\n", a, b, n, val);
					if (primes.contains(val)){ /* already saw this prime */
						still_prime = true;						
					}					
					else{
						still_prime = Functions.isPrime(val);
						if (still_prime == true){ /* new prime found */													
							primes.add(val);
						}
						else{							
							break;
						}
					}					
					n++;
				}
				if (n > nmax){
					System.out.format("New max n=%d, a=%d * b=%d = %d\n", nmax, amax, bmax, amax*bmax);
					nmax = n;
					amax = a;
					bmax = b;
				}
			}
		}
		System.out.format("Maximum n=%d, a=%d * b=%d = %d\n", nmax, amax, bmax, amax*bmax);
	}
	
	public static void testIsPrime(){
		assert(Functions.isPrime(7) == true);
		assert(Functions.isPrime(1000) == false);
		assert(Functions.isPrime(-2) == false);
	}
	
	public static void main(String[] args) {
//		testIsPrime();
		solveProblem();	
	}	
}
