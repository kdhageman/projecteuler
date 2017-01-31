package solutions;

import core.Solution;

public class Problem28 implements Solution {

	private int numLayers;

	public Problem28(int numLayers) {
		this.numLayers = numLayers;
	}

	@Override
	public int number() {
		return 28;
	}

	@Override
	public void solve() {
		long sum = 1; /* number 1 is at layer 0, so assume this */
		long node_value = 1; /* keeps track of the current value of the node */
		int layer = 1;
		while (layer <= numLayers){
			for (int i=0; i<4; i++){ /* four corners */
				node_value += 2*layer;
				sum+= node_value;
			}
			layer++;
		}
		System.out.format("Result: %d\n", sum);
	}
}

