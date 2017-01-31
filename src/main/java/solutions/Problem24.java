package solutions;

import core.Solution;

import java.util.ArrayList;

public class Problem24 implements Solution {

	@Override
	public int number() {
		return 24;
	}

	@Override
	public void solve() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i=0; i<= 9; i++){ /* add all elements to the list */
			l.add(i);
		}

		int c = 1;
		while (c < 1000000){
			l = nextPermutation(l);
			c++;
		}
		System.out.format("Result: %s\n", l);
	}

	public static ArrayList<Integer> nextPermutation( ArrayList<Integer> list){
		/* step 1 from wikipedia (https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order)*/
		int k = -1;
		int l = -1;
		for (int i=list.size() - 2; i>= 0; i--){
			if (list.get(i) < list.get(i+1)){
				k = i;
				break;
			}
		}
		/* stop whenever all elements are ordered in reversed lexicographic order */
		if (k == -1){
			return list;
		}

		/* step 2 */
		for (int i=list.size() - 1; i>= 0; i--){
			if (list.get(k) < list.get(i)){
				l = i;
				break;
			}
		}

		/* step 3*/
		list = swap(list, k, l);

		/* step 4 */
		list = reverse(list, k+1);

		return list;
	}

	/* swaps elements k and l in the given list */
	public static ArrayList<Integer> swap(ArrayList<Integer> list, int k, int l){
		int tmp = list.get(k);
		list.set(k, list.get(l));
		list.set(l, tmp);
		return list;
	}

	/* reverses all elements from the given index n */
	public static ArrayList<Integer> reverse(ArrayList<Integer> list, int n){
		int switchableSlots = list.size() - n;
		int nrSwaps = switchableSlots / 2;
		for (int i=0; i<nrSwaps; i++){
			list = swap(list, n+i, list.size()-1-i);
		}
		return list;
	}
}
