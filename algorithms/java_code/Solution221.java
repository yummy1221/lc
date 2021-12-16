package leetcode;

public class Solution221 {
	
	public static void main(String[]args) {
		Solution221 s = new Solution221();
		char[][] m = {"1101".toCharArray(), 
				"1101".toCharArray(), 
				"1111".toCharArray()
				};
		System.out.println(s.maximalSquare(m));
	}
	
	public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int columns = matrix[0].length;
        int[] side = new int[columns];
        int[] height = new int[columns];
        int left = 0;
        int max = 0;
        int previous = 0;       // edge of square to the left-up corner
        int tmp = 0;
        for(int i = 0; i < rows; i++) {
        	previous = 0;
        	left = 0;
            for(int j = 0; j < columns; j++) {
                tmp = side[j];
                if(matrix[i][j] == '1') {
                    height[j]++;
                    left++;
                    if(previous > 0 && left > previous && height[j] > previous) {
                        side[j] = previous + 1;
                    } else if(previous == 0) {
                    	side[j] = 1;
                    } else {
                        side[j] = Math.min(left, height[j]);
                    }
                } else {
                    side[j] = 0;
                    height[j] = 0;
                    left = 0;
                    side[j] = 0;
                }
                previous = tmp;
                if(side[j] > max) max = side[j];
                System.out.print("p"+previous+""+side[j]);
            }
            System.out.println();
        }
        return max * max;
    }
}
