package problems;

public class Problem28 {

	public static void solveProblem(int num_layers){
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
		System.out.format("After %d layers, the sum of the diagonals is %d", layer, sum);
	}	
	
	public static void main(String[] args) {
		solveProblem(500);	
	}	
}

