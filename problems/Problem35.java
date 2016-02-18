package problems;

import java.util.ArrayList;

import general.Functions;

public class Problem35 { 	
	
	public Problem35(){
		ArrayList<Integer> foundPrimes = new ArrayList<Integer>();
		for (int n=2; n<1000000; n++){
			if (Functions.consideredPrime(n) && !foundPrimes.contains(n) && Functions.isPrime(n)){ /* only consider the number if it is prime (i.e. does not contain an even number) and if we haven't seen it before */
				System.out.format("Considering prime %d:\n", n);								
				ArrayList<Integer> rs = Functions.rotations(n); /* all rotation of n */
				boolean allPrime = true;
				for (int r: rs){ /* check if all rotations of n are prime */ 
					if (r != n && !Functions.isPrime(r)){ /* we already know that n is prime */
						allPrime = false; 
						break;
					}
				}
				if (allPrime){ /* add all primes to the foundPrimes list so that the rotations of n are not checked again */
					for (int r: rs){ /* check if all rotations of n are prime */ 
						foundPrimes.add(r);
					}
					System.out.format("  Added %s\n", rs);
				}
				else {
					System.out.format("  Not all rotations were prime\n", rs);
				}
			}			
		}
		System.out.format("All circular primes: %s\n", foundPrimes);
		System.out.format("Answer: %d\n", foundPrimes.size());
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem35();		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

