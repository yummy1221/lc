import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution1 {
	public static int[] b() {
		return new int[]{1,2};
	}
	public static void main(String[]args) {
		int[] a = b();
		System.out.println(a[0]+" "+a[1]);
	}
}