package problems;

public class Problem38 { 	
		
	public Problem38(){
		int pBest = 0;
		int maxTriangles = 0;
		for (int p=3; p<=1000; p++){
			int numTriangles = 0;
			for (int a=1; a<=Math.ceil(p/2)-1; a++){
				for (int b=1; b<p-2*a; b++){
					int c = p - a - b;
					if (c == Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2))){						
						numTriangles++;
					}
				}
			}
			numTriangles /= 2;
			if (numTriangles > maxTriangles){
				maxTriangles = numTriangles;
				pBest = p;
			}
		}
		System.out.format("Result p(%d): %d\n", pBest, maxTriangles);
	}

	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem38();		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);
	}	
}

