package jobs;

public class GooglePhone {
	public static void main(String[]args) {
		int[] a = {2, 3, 4, 5, 2, 8, 11, 23, 10};
		quickSort(a);
		int len = a.length;
		for(int i = 0; i < len; i++) {
			System.out.println(a[i]);
		}
	}

	public static void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	private static void quickSort(int[] nums, int s, int e) {
		if(s >= e) return;
		int i = s, j = s - 1;
		while(i < e) {
			if(nums[i] <= nums[e]) {
				swap(nums, ++j, i++);
			} else {
				i++;
			}
		}
		swap(nums, ++j, e);
		quickSort(nums, s, j - 1);
		quickSort(nums, j + 1, e);
	}
	private static void swap(int[]nums, int i, int j) {
		if(i == j) return;
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
