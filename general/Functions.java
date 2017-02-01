package general;

import java.util.List;
import java.util.TreeSet;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Contains several helper functions used in Project Euler solutions.
 * @author Kaspar
 */
public class Functions {
	
	/**
	 * Returns the nth triangular number
	 * @param n
	 * @return the nth triangular number
	 */
	public static int triangular(int n){
		if (n > 1){
			return n + triangular(n-1);
		}
		else if (n < 0){
			System.err.println("Negative input for triangular..");
			System.exit(-1);
		}
		return 1;
	}
	
	/**
	 * Returns whether the given number is a triangle number 
	 * @param n
	 * @return 0 when it is not a triangle number, >0 otherwise, in this case it is the result's triangle number
	 */
	public static int isTriangle(int n){		
		double i_est = Math.sqrt(2*n);		
		if (Math.floor(i_est)*(Math.floor(i_est)+1)/2 == n){
			return (int) Math.floor(i_est);
		}
		else if (Math.ceil(i_est)*(Math.ceil(i_est)+1)/2 == n){
			return (int) Math.ceil(i_est);
		}
		return 0;
	}
	
	/**
	 * Returns the number of divisors of the given number.
	 * @param n
	 * @return the number of divisors of n (including 1 and n itself).
	 */
	public static int numDivisors(int n){
		int res = 1; // 'a' is a divisor of itself, so always one.
		for (int i=1; i<=(int) Math.floor(n/2); i++){
			if (n % i == 0){
				res++;
			}
		}
		return res;
	}
	
	/**
	 * Returns whether n is prime; non-zero elements are never prime 
	 * @param n
	 * @return true if n is prime; false otherwise
	 */
	public static boolean isPrime(int n){		
		/* Brute-force exhaust */
		if (n < 2) return false;
		for (int i=2; i<=(int) Math.floor(n/2); i++){
			if (n % i == 0){
				return false;
			}
		}		
		return true;
	}

	/**
	 * Returns whether n is a truncatable prime (i.e. by truncating n left or right will always result in another prime).
	 * @param n
	 * @return true if n is truncatable; false otherwise.
	 */
	public static boolean isTruncatablePrime(int n){
		if (!isPrime(n)) return false; /* n itself should be prime */
		
		int mod = 10; /* left truncatable */		
		while (n % mod != n){
			if (!isPrime(n % mod)){		
				return false;				
			}		
			mod *= 10;
		}
				
		int rn = n/10; /* right truncatable */		
		while (rn > 0){		
			if (!isPrime(rn)){		
				return false;				
			}			
			rn /= 10;
		}
		return true;
	}
	
	/**
	 * Returns all primes equal to - or smaller than - n using the sieve of eratosthenes
	 * @param n - upper limit
	 * @return a TreeSet of all primes equal to - or smaller than - n.
	 */
	public static TreeSet<Integer> getPrimes(int n){
		TreeSet<Integer> res = new TreeSet<Integer>(); /* primes */
		TreeSet<Integer> np = new TreeSet<Integer>(); /* non-primes */
		int p = 2; /* prime */
		while (p < n){
			if(!np.contains(p)){
				res.add(p);
				int c = p;
				while (c < n){
					np.add(c);
					c += p;
				}
			}
			p++;
		}
		
		return res;
	}
	
	/**
	 * Returns a list of all the divisors of n (including 1 and n).
	 * @param n
	 * @return all divisors of n.
	 */
	public static ArrayList<Integer> div(int n){
		ArrayList<Integer> res = properDiv(n);		
		res.add(n);
		return res;
	}
	
	/**
	 * Returns a list of all the proper divisors of n (including 1, excluding n).
	 * @param n
	 * @return all proper divisors of n.
	 */
	public static ArrayList<Integer> properDiv(int n){
		ArrayList<Integer> res = properDivExclOne(n);
		res.add(0, 1);
		return res;
	}
	
	/**
	 * Returns a list of all the proper divisors of n (excluding 1 and n).
	 * @param n
	 * @return all divisors of n.
	 */
	public static ArrayList<Integer> properDivExclOne(int n){
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i=2; i<=(int) Math.floor(n/2); i++){
			if (n % i == 0){
				res.add(i);
			}
		}
		return res;
	}
	
	/**
	 * Returns the sum of all proper divisors of n.
	 * @param n
	 * @return sum of proper divisors of n.
	 */
	public static int sumProperDiv(int n){
		int res = 0;
		List<Integer> pdiv = Functions.properDiv(n);
		for (Integer e : pdiv){
			res += e;
		}
		return res;
	}
	
	/**
	 * Returns whether n is abundant (i.e. the sum of its divisors is larger than n).
	 * @param n
	 * @return true if n is abundant; false otherwise.
	 */
	public static boolean isAbundant(int n){
		return (sumProperDiv(n) > n ? true : false);
	}
	
	/**
	 * Returns the factorization of n as a HashMap.
	 * @param n
	 * @return factorization of n.
	 */
	public static HashMap<Integer, Integer> factorize(int n){
		HashMap<Integer, Integer> hm = null;
		if (numDivisors(n) <= 2){
			hm = new HashMap<Integer, Integer>();
			hm.put(n, 1);
			return hm;
		}
		for (int i=2; i<=(int) Math.floor(n/2); i++){
			if (n % i == 0){
				hm = factorize(n/i);
				if (hm.containsKey(i)){
					hm.put(i, hm.get(i)+1);
				}
				else{
					hm.put(i, 1);
				}
				break;
			}
		}
		return hm;
	}
	
	/**
	 * Returns the number of factors for n (used in problem 12). 
	 * @param n
	 * @return the number of factors of n.
	 */
	public static int numFactorize(int n){
		int res = 1;
		HashMap<Integer, Integer> hm = factorize(n);
		Iterator<Integer> keysIt = hm.keySet().iterator();	
		while (keysIt.hasNext()){
			Integer key = keysIt.next();			
			if (key == 2){
				res *= hm.get(key);
			}
			else{
				res *= (hm.get(key)+1);
			}
		}
		return res;
	}

	/**
	 * Returns the nth Fibonacci number recursively.
	 * @param n
	 * @return the nth Fibonacci number
	 */
	public static BigInteger fibonacci(int n){		
		if (n == 1 || n == 2){
			return BigInteger.ONE;
		}
		return fibonacci(n-1).add(fibonacci(n-2));
	}

	/**
	 * Returns the cycle size of 1/n in (e.g. 1/6 = 1.6(6..))
	 * @param n
	 * @return the cycle size of 1/n.
	 */
	public static int recurringCycleSize(BigInteger n){
		BigInteger ten = new BigInteger("10");				
		
		/* obtain the fullstring */
		String fstring = "";
		for (int i = 1; i <= n.intValue()*3+2; i++){ /* fstring should contain a loop three times plus at most two prepended zeroes */
			String d = ten.pow(i).divide(n).mod(ten).toString(); /* read next digit */
			fstring += d;
		}
		
		/* use tortoise/hare mechanism to find a cycle */
		int t = 0;
		int h = 1;
		while (true){						
			if (fstring.charAt(t) == fstring.charAt(h) && fstring.charAt(t) == fstring.charAt(2*h-t)){  /* we have a potential cycle (3 occurences) */				
				int clambda = h - t; /* candidate lambda */
				/* all characters between the hare and the tortoise (left) should be repeated after the hare (right) */
				String left = fstring.substring(t, t+clambda); 
				String right = fstring.substring(h, h+clambda);
//				System.out.format("%d: candidate found: t=%d, h=%d\n", n, t, h);
				if (left.equals(right)) break;
			}
			t++;
			h+=2;
		}		
				
		/* find lambda (cycle size) and mu (start of cycle) */
		int lambda = h - t;
				
		return lambda;
	}
	
	/**
	 * Returns a list of all indices of the occurrence of a substring in a fullstring.
	 * @param fstring - full string
	 * @param sstring - substring
	 * @return list of all indices
	 */
	public static ArrayList<Integer> indicesOf(String fstring, String sstring){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (sstring.isEmpty()){
			return res;
		}
		int i = fstring.indexOf(sstring);
		while (i != -1){
			res.add(i);			
			i = fstring.indexOf(sstring, i+1);						
		}
		return res;		
	}
	
	/**
	 * Returns a list of all rotations of n (i.e. rotations(123) = {231, 312, 123}).
	 * @param n
	 * @return a list of all rotations of n.
	 */
	public static ArrayList<Integer> rotations(int n){
		ArrayList<Integer> res = new ArrayList<Integer>();
		String next = Integer.toString(n).substring(1) + Integer.toString(n).charAt(0);
		res.add(Integer.parseInt(next));
		while (Integer.parseInt(next) != n){			
			next = next.substring(1) + next.charAt(0);
			res.add(Integer.parseInt(next));
		}
		return res;		
	}
	
	/**
	 * A very basic way to determine if n should be even considered a prime candidate: it should be odd and not end with a 5.
	 * @param n
	 * @return whether n should be considered as a prime candidate.
	 */
	public static boolean consideredPrime(int n){
		int d = n % 10; /* last digit */
		return (n==2 || n==5) || !(d == 0 || d == 2 || d == 4 || d == 5 || d == 6 || d ==8);
	}
	
	/**
	 * A very basic way to determine if n (and any circular numbers of n) should be even considered a prime candidate: it may not contain an odd number or a 5.
	 * @param n
	 * @return whether n (and any circular number of n) should be considere a prime candidate.
	 */
	public static boolean consideredPrimeCircular(int n){
		String nString = Integer.toString(n);
		return (n==2 || n==5) || !(nString.contains("0") || nString.contains("2") || nString.contains("4") || nString.contains("5") || nString.contains("6") || nString.contains("8"));
	}

	/**
	 * Returns whether string s is a palindrome (i.e.  s == reverse(s))
	 * @param s
	 * @return true if s is a palindrome; false otherwise.
	 */
	public static boolean isPalindrome(String s){		
		int len = s.length();		
		for (int i=0; i<(len-(len % 2 == 0 ? 0 : 1))/2; i++){
			if (s.charAt(i) != s.charAt(len-1-i)) return false;
		}
		return true;
		
	}

	/**
	 * Returns whether n is pandigital (i.e. consists of all integers 1-9)
	 * @param n
	 * @return true if n is pandigital; false otherwise.
	 */
	public static boolean isPalindrome(int n){
		String s = Integer.toString(n);
		return isPalindrome(s);
	}
	
	/**
	 * Returns whether n is pandigital (i.e. consists of all integers 1-9)
	 * @param s
	 * @return true if n is pandigital; false otherwise.
	 */
	public static boolean isPandigital(String s){
		if (s.length() != 9) return false;
		for (int i=1; i<= 9; i++){
			if (!s.contains(Integer.toString(i))) return false;
		}
		return true;			
	}

	/**
	 * Computes the next permutation of n in lexicographical order (https://www.nayuki.io/page/next-lexicographical-permutation-algorithm).
	 * @param n 
	 * @param decreasing indicates whether the permutations are computed in increased or decreased lexicographical order.
	 * @return the next permutation if it exists; -1 otherwise.
	 */
	public static int nextPermutation(int n, boolean decreasing){
		/* convert n to an int[] using a String */
		String nString = Integer.toString(n);
		int[] a = new int[nString.length()]; /* int array used to compute the next permutation */
		for (int i=0; i<nString.length(); i++){
			a[i] = Integer.parseInt(nString.substring(i, i+1));
		}
		
		/* find longest non-increasing suffix */
		int i = a.length - 1;
		if (decreasing){
			while (i > 0 && a[i-1] <= a[i])
		        i--;
		}
		else{
		    while (i > 0 && a[i - 1] >= a[i])
		        i--;
		}
		
		if (i <= 0) return -1;
		
		int j = a.length-1;
		if (decreasing){
			while(a[j] >= a[i-1]){
				j--;
			}
		}
		else{
			while(a[j] <= a[i-1]){
				j--;
			}
		}		
		
		/* swap n[i-1] and n[j] */
		int tmp = a[i-1];
		a[i-1] = a[j];
		a[j] = tmp;
		
		 // Reverse the suffix
	    j = a.length - 1;
	    while (i < j) {
	        tmp = a[i];
	        a[i] = a[j];
	        a[j] = tmp;
	        i++;
	        j--;
	    }
		
	    /* convert int[] back to int using String */
	    nString = "";
	    for (int d : a){
	    	nString += Integer.toString(d);
	    }
	    
		return Integer.parseInt(nString);
	}
	
	/**
	 * Identical as nextPermutation(int n, boolean decreasing), except it works on String rather than integer, allowing integer starting with a 0.
	 * @param n
	 * @param decreasing
	 * @return
	 */
	public static String nextPermutation(String n, boolean decreasing){
		/* convert n to an int[] using a String */		
		int[] a = new int[n.length()]; /* int array used to compute the next permutation */
		for (int i=0; i<n.length(); i++){
			a[i] = Integer.parseInt(n.substring(i, i+1));
		}
		
		/* find longest non-increasing suffix */
		int i = a.length - 1;
		if (decreasing){
			while (i > 0 && a[i-1] <= a[i])
		        i--;
		}
		else{
		    while (i > 0 && a[i - 1] >= a[i])
		        i--;
		}
		
		if (i <= 0) return null;
		
		int j = a.length-1;
		if (decreasing){
			while(a[j] >= a[i-1]){
				j--;
			}
		}
		else{
			while(a[j] <= a[i-1]){
				j--;
			}
		}		
		
		/* swap n[i-1] and n[j] */
		int tmp = a[i-1];
		a[i-1] = a[j];
		a[j] = tmp;
		
		 // Reverse the suffix
	    j = a.length - 1;
	    while (i < j) {
	        tmp = a[i];
	        a[i] = a[j];
	        a[j] = tmp;
	        i++;
	        j--;
	    }
		
	    /* convert int[] back to int using String */
	    n = "";
	    for (int d : a){
	    	n += Integer.toString(d);
	    }
	    
		return n;
	}
}