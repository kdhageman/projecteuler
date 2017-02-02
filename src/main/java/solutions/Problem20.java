package solutions;

import java.util.HashMap;
import java.util.LinkedList;

import core.Solution;
import util.Functions;

public class Problem20 implements Solution {

	@Override
	public int number() {
		return 20;
	}

	@Override
	public void solve() {
		LinkedList<Long> l = new LinkedList<Long>();
		l.add((long) 1);
		for(int i=1; i<=100; i++){
			l = mult(l,i);
		}
		System.out.println(l);

		long s = 0;
		for (Long e : l){
			s += e;
		}
		System.out.println(s);
	}

	private LinkedList<Long> mult(LinkedList<Long> l, int n){
		for(int i=0; i<l.size(); i++){
			l.set(i, l.get(i)*n);
		}
		return fixList(l);
	}

	/* makes sure that the list only contains values smaller than 10 */
	private LinkedList<Long> fixList(LinkedList<Long> l){
		long c = l.get(0);
		if (c >= 10){
			l.set(0, c % 10);
			l.addFirst(c / 10);
			l = fixList(l);
		}
		for (int i=1; i<l.size(); i++){
			c = l.get(i);
			if (c >= 10){
				l.set(i, c % 10);
				l.set(i-1, l.get(i-1) + (c / 10));
				l = fixList(l);
			}
		}
		return l;
	}
}
