package problems;

public class Problem28 {

	public Problem28(int num_layers){
		long sum = 1; /* number 1 is at layer 0, so assume this */
		long node_value = 1; /* keeps track of the current value of the node */
		int layer = 1;
		while (layer <= num_layers){			
			for (int i=0; i<4; i++){ /* four corners */
				node_value += 2*layer;
				sum+= node_value;
			}			
			layer++;
		}		
		System.out.format("Result: %d\n", sum);
	}	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		new Problem28(500);		
		
		long end = System.currentTimeMillis();
		System.out.format("Took %d ms in total\n", end-start);	
	}	
}

