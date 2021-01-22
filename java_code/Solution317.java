package leetcode;

import java.util.*;
public class Solution317 {
	public static void main(String[]args) {
		int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(shortestDistance(grid));
	}
    public static int shortestDistance(int[][] grid) {
    	int rows = grid.length;
        if(rows == 0) return -1;
        int columns = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] count = new int[rows][columns];
        int[][] step = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int tmp = 0;    // size of queue
        int length = 0; // step now
        int x = 0, y = 0;   // (x, y) new point
        int[] old;
        int[][] visited = new int[rows][columns];
        int marked = 1;
        boolean empty = false;
        int total = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(0 == grid[i][j])
                    total++;
            }
        }
        int emptys = total;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(1 == grid[i][j]) {
                    queue.clear();
                    queue.add(new int[]{i, j});
                    length = 1;
                    emptys = total;
                    while(!queue.isEmpty()) {
                        tmp = queue.size();
                        for(int k = 0; k < tmp; k++) {
                            old = queue.removeFirst();
                            for(int m = 0; m < 4; m++) {
                                x = old[0] + step[m][0];
                                y = old[1] + step[m][1];
                                if(x >= 0 && x < rows && y >= 0 && y < columns && grid[x][y] == 0 && visited[x][y] != marked && count[x][y] != -1) {
                                    queue.add(new int[]{x, y});
                                    emptys--;
                                    count[x][y] += length;
                                    visited[x][y] = marked;
                                }
                            }
                        }
                        length++;
                    }
                    if(emptys != 0) {
                        for(int m = 0; m < rows; m++) {
                            for(int n = 0; n < columns; n++) {
                                if(visited[m][n] != marked) {
                                    visited[m][n] = marked;
                                    count[m][n] = -1;
                                }
                            }
                        }
                    }
                    marked ^= 1;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
            	System.out.print(grid[i][j] + " ");
                if(grid[i][j] == 0 && count[i][j] != -1) {
                    if(count[i][j] < min) min = count[i][j];
                    if(!empty) empty = true;
                }
            }
            System.out.println();
        }
        if(!empty) return -1;
        return min;
    }
}