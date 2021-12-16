import java.io.*;
import java.util.Scanner;

public class Solution31 {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
    Scanner scanner = new Scanner(System.in);
    
    long M = scanner.nextLong();
    int N = scanner.nextInt();
    
    if (N == 0) {
        return;
    } 
    // Math way to solve kth permutation problem.
	long[] nums = new long[N * 2];
	long permutation = 1;

	for (int i = 0; i < N; i++) {
		nums[i] = i;
        // Calculate N!
		permutation *= (long) (i + 1);
	}

	for (int i = 0; i < N; i++) {
		permutation = permutation / (N - i);
        // Chosen index.
		int index = (int) (M / permutation);
		System.out.print(nums[index] + " ");
        // Left shift by one.
        System.arraycopy(nums, index + 1, nums, index, N - i - index);
		M %= permutation;
	}
	System.out.println();
}
}