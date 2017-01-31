package solutions;

import core.Solution;

import java.util.HashMap;

public class Problem19 implements Solution {

	private HashMap<Integer, Integer> daysPerMonth;

	@Override
	public int number() {
		return 19;
	}

	@Override
	public void solve() {
		initHashMap();

		int s = 0; /* keeps track of number of sundays */

		/* loop over the years */
		for (int y=1901; y<=2000; y++){
			int c = 0;
			int dY = y - 1900 - 1;
			System.out.format("%d:\n", y);
			System.out.println(Math.ceil(dY/4));
			/* loop over the days of january */
			for (int m=1; m<=12; m++){
				int dayofweek = getDayForDate(1, m, y);
				s += dayofweek == 7 ? 1 : 0;
				if (dayofweek == 7){
					System.out.format("%d-%d-%d\n", 1, m, y);
					c++;
				}
			}
			System.out.format("total: %d\n\n", c);
		}
		System.out.println(s);
	}

	private int getDayForDate(int d, int m, int y){
		int daysPassed = 0;

		/* number of years passed since 01-01-1900 */
		int dY = y - 1900;
		daysPassed += dY * 365 + Math.ceil((dY - 1)/4); /* each year has 365 days, with the exception of leap years, which are (including 1900), all years divisible by 4 */

		/* number of months passed this year (excluding the current month) */
		for (int i=1; i<m; i++){
			if (i == 2){ /* february */
				daysPassed += (y % 4 == 0 ? 29 : 28); /* current leap year has not been considered yet */
			}
			else{ /* any other month */
				daysPassed += daysPerMonth.get(i);
			}
		}

		/* number of days passed this month */
		daysPassed += d-1;
		return (daysPassed % 7) + 1;
	}

	private void initHashMap(){
		daysPerMonth = new HashMap<Integer, Integer>();
		daysPerMonth.put(1, 31);
		daysPerMonth.put(3, 31);
		daysPerMonth.put(4, 30);
		daysPerMonth.put(5, 31);
		daysPerMonth.put(6, 30);
		daysPerMonth.put(7, 31);
		daysPerMonth.put(8, 31);
		daysPerMonth.put(9, 30);
		daysPerMonth.put(10, 31);
		daysPerMonth.put(11, 30);
		daysPerMonth.put(12, 31);
	}
}
