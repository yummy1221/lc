package cryptography;

public class Review {
	public static void koblitz() {
		int x = 51;
		int a = 2;
		int b = 7;
		int p = 179;
		int y = (int)Math.pow(x, 3) + a * x + b;
		y = y % p;
		System.out.println(y);
	}
	public static void main(String[] args) {
		koblitz();
	}
}
