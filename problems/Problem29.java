package problems;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem29 {

	public static void solveProblem(){
		int[] arange = {2, 100};
		int[] brange = {2, 100};
		ArrayList<String> l = new ArrayList<String>();
		for (int a = arange[0]; a <= arange[1]; a++){
			BigInteger abig = new BigInteger(Integer.toString(a));
			for (int b = brange[0]; b <= brange[1]; b++){				
				BigInteger c = abig.pow(b);	
				if (!l.contains(c.toString())){
					l.add(c.toString());
				}
			}
		}
		System.out.format("%d-%d=%d\n", (arange[1]-arange[0]+1)*(brange[1]-brange[0]+1), l.size(), (arange[1]-arange[0]+1)*(brange[1]-brange[0]+1)-l.size());
	}	
	
	public static void main(String[] args) {
		solveProblem();	
	}	
}

