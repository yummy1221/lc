package leetcode;

public class Solution85 {
	public static void main(String[]args) {
		Solution85 s = new Solution85();
		char[][] m = {"1101".toCharArray(), 
				"1101".toCharArray(), 
				"1111".toCharArray()
				};
		System.out.println(s.maximalRectangle(m));
	}
	public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int columns = matrix[0].length;
        int[] height = new int[columns];
        int[] left = new int[columns];
        int[] right = new int[columns];
        int cur_left = 0;
        int cur_right = 0;
        int max = 0;
        int tmp = 0;
        for(int i = 0; i < columns; i++)
        	right[i] = columns - 1;
        for(int i = 0; i < rows; i++) {
            cur_left = 0;
            cur_right = columns - 1;
            for(int j = 0; j < columns; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(cur_left, left[j]);
                } else {
                    height[j] = 0;
                    left[j] = 0;
                    cur_left = j + 1;
                }
                
                if(matrix[i][columns-1-j] == '1') {
                    right[columns-1-j] = Math.min(cur_right, right[columns-1-j]);
                } else {
                    cur_right = columns - j - 2;
                    right[columns-1-j] = columns - 1;
                }
            }
            for(int j = 0; j < columns; j++) {
            	System.out.println("i: " + i + " , j: "+j + " " +left[j] + " "+right[j] +" "+ height[j]);
                tmp = (right[j] - left[j] + 1) * height[j];
                if(tmp > max) max = tmp;
            }
        }
        return max;
    }
}
