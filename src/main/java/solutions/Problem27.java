package solutions;

import java.util.ArrayList;

import core.Solution;
import util.Functions;

public class Problem27 implements Solution {

	@Override
	public int number() {
		return 27;
	}

	@Override
	public void solve() {
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

					nmax = n;
					amax = a;
					bmax = b;
				}
			}
		}
		System.out.format("Result: %d\n", amax*bmax);
	}
}
