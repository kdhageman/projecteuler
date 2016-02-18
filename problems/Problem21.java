package problems;

import general.Functions;

public class Problem21 {

	public static void main(String[] args) {
		int s = 0;
		/* 1 to 10000 */
		for (int i=1; i<=10000; i++){
			int pdivi = Functions.sumProperDiv(i);
			if (pdivi < 10000 && pdivi != i && Functions.sumProperDiv(pdivi) == i){
				/* i and pdivi are an amicable pair */
				System.out.format("%d : %d \n", i, pdivi);
				s += pdivi;
			}
		}
		System.out.println(s);
	}
	

}
