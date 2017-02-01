package sorting;

public class Main {

	public static void main(String[] args) {
		int[] list = GenerateList.generate(1000);
		System.out.println(list.length);
		for (int i=0; i<list.length; i++){			
			System.out.printf("%d ", list[i]);
		}
		System.out.printf("%n");
		System.out.flush();
	}
}
