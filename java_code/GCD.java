import java.util.ArrayList;
import java.util.List;

public class GCD {
	private static int result;
	public static int solveNQueens(int n) {
        result = 0;  
        int[] row = new int[n];
        int[] queens = new int[n];
        int len;
        // recursive starts
        for (int i = 0; i < n; i++) {
            row[i] = 1;             
            queens[0] = i; 
            sovleNQueens(row, 1, queens);
            row[i] = 0;
        }
        return result;
    }
    public static void sovleNQueens(int [] row, int row_num, int[] queens) {
        int n = row.length;
        if((row_num) == n) {
            result = result + 1;
            return;
        }
        boolean tmp = false;
        for (int i = 0; i < n; i++) {
            tmp = false;
            if(row[i]==1) {
                continue;
            }
            for(int j = 0; j < row_num; j++) {
                if(Math.abs(row_num-j) == Math.abs(queens[j]-i)) {
                    tmp = true;
                    break;
                }
            }
            if(tmp) continue;
            row[i] = 1;
            queens[row_num] = i;
            sovleNQueens(row, row_num+1, queens);
            row[i] = 0;
            
        }
    }
	
	public static void main(String[] args) {
		System.out.println(solveNQueens(6));
		
	}
}
