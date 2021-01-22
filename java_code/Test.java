import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;
import java.util.Scanner;

public class Test {
	
	static class PQSort implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
	public static void main(String[]args) {
		int[][] direction = {{-1,2}, {-2, 1}, {1,2}, {2,1}, {-1,-2}, {-2,-1}, {1,-2}, {2,-1}};
	    int len = 8;
	    Scanner scanner = new Scanner(System.in);
	    int[] start = new int[2];   // x - 0, y - 1
	    int b_x, b_y;
	    int x, y;
	    int[] end = new int[2];
	    b_x = scanner.nextInt();
	    b_y = scanner.nextInt();
	    int[][] board = new int[b_x][b_y];
	    start[0] = scanner.nextInt();
	    start[1] = scanner.nextInt();
	    end[0] = scanner.nextInt();
	    end[1] = scanner.nextInt();
	    int blocks = scanner.nextInt();
	    for(int i = 0; i < blocks; i++) {
	        x = scanner.nextInt();
	        y = scanner.nextInt();
	        board[x][y] = -1;   // -1 indicates a block is here
	    }
	    Queue<int[]> q = new ArrayDeque<>();
	    q.add(start);
	    int[] move;
	    board[start[0]][start[1]] = 1;
	    int count;
	    while(!q.isEmpty()) {
	        move = q.poll();
	        count = board[move[0]][move[1]];
	        for(int i = 0; i < len; i++) {
	            x = move[0] + direction[i][0];
	            y = move[1] + direction[i][1];
	            if(x<0 || x>=b_x || y<0 || y>=b_y) continue;
	            if(x == end[0] && y == end[1]) {
	                System.out.println(count);
	                return;
	            } else if(board[x][y] != 0) {
	                continue;
	            } else {
	                board[x][y] = count + 1;
	                q.add(new int[]{x, y});
	            }
	        }
	    }
	}
}
