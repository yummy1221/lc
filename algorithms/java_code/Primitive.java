import java.util.Arrays;

// Cryptography Problem Set 5
// author: Xiaoyi Li
// date: 10/31/2015
// Problem 6
public class Primitive {
	public static int pow(int a, int b, int prime) {
		int result = 1;
		for(int i=0; i<b; i++) {
			result = (result*a) % prime;
		}
		return result;
	}
	public static void calculatePrimitiveRoots(int prime, int primitive) {
		int p = prime;
		int a[] = new int[p];
		int g=primitive;
		for(int i=1; i<p; i++) {
			a[i] = Primitive.pow(g, i, p);
			a[i] = a[i]%p;
		}
		Arrays.sort(a);
		for(int i=1; i<a.length; i++) {
			System.out.print(a[i]+" ");
			if(i%10==0)
				System.out.println();
		}
	}
	
	public static void generateCD(int num) {
		for(int i=1; i<=num; i++) {
			if((num/i)*i==num){
				System.out.print(i+", ");
			}
		}
	}
	public static void lucas(int g) {
		int[] a={2, 3, 5, 6, 10, 15, 25, 30, 50, 75, 125, 150, 250, 375, 750};
		int tmp = 0;
		for(int i=0; i<a.length; i++) {
			tmp = Primitive.pow(g, 750/a[i], 751);
			tmp = tmp%751;
			System.out.print(tmp+" ");
		}
	}
	
	public static int gcd(int a, int b) {
		int c;
		while(a!=0 && b!=0) {
			c = a;
			a = b%a;
			b = c;
		}
		return a+b;
	}
	public static void primitiveAll() {
		int[] result = new int[200];
		int count = 0;
		for(int i=1; i<750; i++) {
			if(gcd(i, 750)==1) {
				// System.out.print(Primitive.pow(3, i, 751)+" ");
				result[count] = Primitive.pow(3, i, 751);
				//if(count%10==0)
					//System.out.println();
				count++;
			}
		}
		Arrays.sort(result);
		for(int i=0; i<result.length; i++) {
			if(i%10==0)
				System.out.println();
			System.out.print(result[i]+" ");
		}
		System.out.println();
		System.out.print(count);
	}
	public static void main(String[]args) {
		// calculatePrimitiveRoots(751, 3);
		// generateCD(750);
		// System.out.println(gcd(100,25));
		// primitiveAll();
		lucas(4);
	}
}
