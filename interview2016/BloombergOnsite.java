package jobs;

import java.util.*;

// Preparation for Onsite Interview
public class BloombergOnsite {
	public static void main(String[]args) {
		int a = -12345;
		System.out.println(reverseInteger(a));
	}
	// reverse integer 不用考虑溢出
	public static int reverseInteger(int num) {
		int rst = 0;
		while(num != 0) {
			rst = rst * 10 + (num % 10);
			num = num / 10;
		}
		return rst;
	}
}
