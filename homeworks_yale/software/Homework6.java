package software;

public class Homework6 {
	public static void main(String[]args) {
		int z = 0, x = 0, y = 0;
		int w = 42;
		do {
			z = 0;
			x = y;
			if(w == 42) {
				x = x + 1;
				z = 1;
			}
		} while(x != y);
		System.out.println(z);
	}
}
