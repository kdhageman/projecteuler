package sorting;

import java.util.Random;

public class GenerateList {
	public static int[] generate(int size){
		int[] result = new int[size];
		Random rand = new Random();
		for (int i=0; i<size; i++){
			result[i] =  rand.nextInt(size*10);
		}
		return result;
	}
}
