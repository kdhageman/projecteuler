package problems;

public class Problem31 { 	
		
	static int[] coins = {2, 5, 10, 20, 50, 100, 200};
	
	public Problem31(){
		System.out.println(p(200, 200, 0));
	}
	
	/* find number of ways to divide 'n' one-pennies */
	public static int p(int n, int max, int depth){
		int res = 1;
		
		for (int c : coins){ /* try every coin type, as long as its not larger than our defined max */
			if (c <= n && c <= max){
				res += p(n-c, c, depth+1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem31();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

