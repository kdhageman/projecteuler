package problems;

public class Problem15 {

	static long[][] routes;
	
	public Problem15(){
		routes = new long[21][21];
		routes[0][0] = 1;
		/* height */
		for (int j=0; j<routes[0].length; j++){			
			/* width */
			for (int i=0; i<routes[0].length; i++){				
				if (i != 0){
					routes[i][j] += routes[i-1][j];
				}
				if (j != 0){
					routes[i][j] += routes[i][j-1]; 
				}						
			}
		}
		System.out.format("Result: %d\n", routes[20][20]);
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem15();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}
	
	public static int routes(int w, int h){
		/* base cases */
		if ((w == 1 && h == 0) || w == 0 && h == 1)
			return 1;
		
		/* otherwise */
		int r = 0;
		if (w != 0){
			r += routes(w-1, h);
		}
		if (h != 0){
			r += routes(w, h-1);
		}
		return r;	
	}
}
