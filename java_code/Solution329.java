package leetcode;

public class Solution329 {
	
	public static void main(String[]args) {
		Solution329 s = new Solution329();
		int m[][] = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
		s.longestIncreasingPath(m);
	}
	
	private int[][] step = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        if(row == 0) return 0;
        int column = matrix[0].length;
        int[][] length = new int[row][column];
        int max = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                length[i][j] = findPath(length, i, j, matrix);
                if(length[i][j] > max) max = length[i][j];
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
            	System.out.print(length[i][j] + " ");
            }
            System.out.println();
        }
        return max;
    }
    
    private int findPath(int[][] length, int x, int y, int[][] matrix) {
        if(length[x][y] != 0) return length[x][y];
        int r = 0, c = 0;
        int max = 1;
        int len = 0;
        for(int i = 0; i < 4; i++) {
            r = x + step[i][0];
            c = y + step[i][1];
            if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] > matrix[x][y]) {
                len = findPath(length, r, c, matrix) + 1;
                if(len > max) max = len;
            }
        }
        return max;
    }
}
