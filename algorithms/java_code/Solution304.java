
public class Solution304 {
	int[][] my_matrix;
    int[][] sum;
    public Solution304(int[][] matrix) {
        my_matrix = matrix.clone();
        int row = matrix.length;
        if(row == 0) return;
        int column = matrix[0].length;
        sum = new int[row][column];
        int s = 0;
        for(int i = 0; i < row; i++) {
            s = 0;
            for(int j = 0; j < column; j++) {
                if(i - 1 >= 0) {
                    s = s + my_matrix[i][j];
                    sum[i][j] = s + sum[i-1][j];
                } else {
                    s = s + my_matrix[i][j];
                    sum[i][j] = s;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(row1 == 0 && col1 == 0) return sum[row2][col2];
        if(row1 == 0) return (sum[row2][col2] - sum[row2][col1-1]);
        if(col1 == 0) return (sum[row2][col2] - sum[row1-1][col2]);
        return (sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1]);
    }
    
    public static void main(String[]args) {
    	int[][] m = {{3,0,1,4,2}, {5,6,3,2,1}, {1,2,0,1,5}, {4,1,0,1,7}, {1,0,3,0,5}};
    	//,sumRegion(1,1,2,2),sumRegion(1,2,2,4)
    	Solution304 s = new Solution304(m);
    	System.out.println(s.sumRegion(2,1,4,3));
    	
    }

}
