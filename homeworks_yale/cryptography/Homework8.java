package cryptography;

public class Homework8 {
	public static void blumInteger(int r) {
		if(r < 11) {
			System.out.println("p: " + 3 + " q: " + 7 + " n: " + 21);
			return;
		}
		int p = 0, q = 0;
		int n = 0;
		for(int i = 0; i < 4; i++) {
			if((r - i) % 4 == 3) {
				p = r - i;
				q = p - 4;
			}
		}
		n = p * q;
		System.out.println("p: " + p + " q: " + q + " n: " + n);
	}
	public static boolean isPrime(long x) {
		long end = (long)Math.sqrt(x);
		for(int i = 2; i < x; i++) {
			if(x%i == 0)
				return false;
		}
		return true;
	}
	public static void primeBetween(long small, long big) {
		for(long i = small; i < big; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	public static void main(String[]args) {
		long v = 0x9965;
		long p = 0;
		long q = 0;
		for(int i = 3; i < Math.sqrt(v); i++) {
			if(v % i == 0) {
				p = i;
				q = v/i;
				System.out.println("p: " + p + " q: " + q + " n: " + v);
			}
		}
		System.out.println((int)(Math.log(v)/Math.log(2)) + 1);
		System.out.println(p % 4 == 3);
		System.out.println(q % 4 == 3);
		//int rand = 0xcc659;
		//blumInteger(rand);
	}
}
