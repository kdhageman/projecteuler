package solutions;

import core.Solution;

public class Problem30 implements Solution {

	@Override
	public int number() {
		return 30;
	}

	@Override
	public void solve() {
		int sum = 0;

		/* five digits */
		for (int a=1; a<10; a++){ /* a in {2-9} */
			int sum_powers = (int) Math.pow(a, 5);
			if (sum_powers == a  && a != 1){
				sum += sum_powers;
			}

			for (int b=0; b<10; b++){ /* b in {0-9} */
				sum_powers = (int) (Math.pow(a, 5) + Math.pow(b, 5));
				if (sum_powers == a*10 + b){
					sum += sum_powers;
				}

				for (int c=0; c<10; c++){ /* c in {0-9} */
					sum_powers = (int) (Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5));
					if (sum_powers == a*100 + b*10 + c){
						sum += sum_powers;
					}

					for (int d=0; d<10; d++){ /* d in {0-9} */
						sum_powers = (int) (Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + Math.pow(d, 5));
						if (sum_powers == a*1000 + b*100 + c*10 + d){
							sum += sum_powers;
						}

						for (int e=0; e<10; e++){ /* e in {0-9} */
							sum_powers = (int) (Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + Math.pow(d, 5) + Math.pow(e, 5));
							if (sum_powers == a*10000 + b*1000 + c*100 + d*10 + e){
								sum += sum_powers;
							}

							for (int f=0; f<10; f++){ /* f in {0-9} */
								sum_powers = (int) (Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + Math.pow(d, 5) + Math.pow(e, 5) + Math.pow(f, 5));
								if (sum_powers == a*100000 + b*10000 + c*1000 + d*100 + e*10 + f){
									sum += sum_powers;
								}

								for (int g=0; g<10; g++){ /* f in {0-9} */
									sum_powers = (int) (Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + Math.pow(d, 5) + Math.pow(e, 5) + Math.pow(f, 5) + Math.pow(g, 5));
									if (sum_powers == a*1000000 + b*100000 + c*10000 + d*1000 + e*100 + f*10 + g){
										sum += sum_powers;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.format("Result: %d\n", sum);
	}
}

