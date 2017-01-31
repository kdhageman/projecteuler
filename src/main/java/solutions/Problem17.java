package problems;

import java.util.HashMap;

public class Problem17 {
	
	static HashMap<Integer, Integer> hm;
	
	public Problem17(){
		hm = initHashMap();
		
		int sum = 0;
		for (int i=1; i<= 1000; i++){
			sum += numLetters(i, 0);
		}
		sum += 3; /* special case: 100 = one + hundred, rather than just hundred */
		System.out.format("Result: %d\n", sum);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem17();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}
	
	public static int numLetters(int n, int l){
		int res = 0;
		
		for (int i=0; i<l; i++){
			System.out.format("  ");
		}
		System.out.println(n);
		
		/* n is directly obtained from hm (e.g. 14) */
		if (hm.containsKey(n)){
			res += hm.get(n);
		}
		/* 21 <= n <= 99 (e.g. 45) */
		else if (21 <= n && n <= 99){			
			res += numLetters((n / 10)*10, l+1); 	/* (e.g. 40) */
			res += numLetters(n % 10, l+1); 		/* (e.g. 5) */
		}
		
		/* 100 <= n <= 999 (e.g. 445) */
		else if (100 <= n && n <= 999){
			res += numLetters(n/100, l+1); 			/* (e.g. 4) */
			res += numLetters(100, l+1);	 		/* (e.g. 100) */
			if (n % 100 != 0){
				res += 3;             				/* and */
				res += numLetters(n % 100, l+1); 	/* (e.g. 45) */				
			}
		}
		
		/* error if none of the cases handles n */
		else {
			System.out.format("%d: is not handled by any of the cases\n", n);
		}
		return res;
	}
	
	public static HashMap<Integer, Integer> initHashMap(){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		hm.put(1, 3);
		hm.put(2, 3);
		hm.put(3, 5);
		hm.put(4, 4);
		hm.put(5, 4);
		hm.put(6, 3);
		hm.put(7, 5);
		hm.put(8, 5);
		hm.put(9, 4);
		hm.put(10, 3);
		hm.put(11, 6);
		hm.put(12, 6);
		hm.put(13, 8);
		hm.put(14, 8);
		hm.put(15, 7);
		hm.put(16, 7);
		hm.put(17, 9);
		hm.put(18, 8);
		hm.put(19, 8);
		hm.put(20, 6);
		hm.put(30, 6);
		hm.put(40, 5);
		hm.put(50, 5);
		hm.put(60, 5);
		hm.put(70, 7);
		hm.put(80, 6);
		hm.put(90, 6);
		hm.put(100, 7); /* hundred != one hundred */
		hm.put(1000, 11);
		return hm;
	}
}

