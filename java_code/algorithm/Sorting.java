package algorithm;

import software.SATSolver;

// common sorting algorithms
public class Sorting {
	public static void main(String[] args) {
		int[] a = { 7, 10, 5, 3, 8, 4, 2, 9, 6 };
		
		long startTime = System.currentTimeMillis();
		shellSort(a);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime+"ms");
		System.out.println(totalTime/1000+"s");

		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}

	// Selection Sort O(n*n)
	public static void selectionSort(int[] arr) {
		int len = arr.length;
		int min = 0;
		for (int i = 0; i < len; i++) {
			min = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			swap(arr, i, min);
		}
	}

	// Insertion Sort
	public static void insertionSort(int[] arr) {
		int len = arr.length;
		for(int i = 0; i < len; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1])
					swap(arr, j, j-1);
				else
					break;
			}
		}
	}
	
	// Shell Sort
	public static void shellSort(int[]arr) {
		int len = arr.length;
		int h = 1;
		while(h < len / 3) h = 3 * h + 1;
		while(h >= 1) {
			for(int i = h; i < len; i++) {
				for(int j = i; j >= h; j = j - h) {
					if(arr[j] < arr[j-h])
						swap(arr, j, j - h);
				}
				System.out.print(i+":\t");
				for (int k = 0; k < arr.length; k++)
					System.out.print(arr[k] + " ");
				System.out.println();
			}
			h = h / 3;
		}
	}
	
	// swap two elements
	private static void swap(int[] a, int i, int j) {
		if (i == j)
			return;
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	// Bubble Sort
	public static void bubbleSort(Comparable[] arr) {

	}
}
