
public class Solution303 {
	int[] my_nums;
    int[] sum;
    public Solution303(int[] nums) {
        my_nums = nums.clone();
        int len = my_nums.length;
        if(len == 0) return;
        sum = new int[len];
        sum[0] = my_nums[0];
        for(int i = 1; i < len; i++) {
            sum[i] = sum[i-1] + my_nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return (sum[j] - sum[i] + my_nums[i]);
    }
    
	public static void main(String[] args) {
		
		int[] b = {-2,0,3,-5,2,-1};
		Solution303 a = new Solution303(b);
		//System.out.println(a.sumRange(0,2));
		//System.out.println(a.sumRange(2,5));
		//System.out.println(a.sumRange(0,5));
		//System.out.println(b[2]);
		int[][] o = {{1,2,3},{1,3,5}};
		int[][] oo = o.clone();
		System.out.println(oo[0].length);
	}
}
