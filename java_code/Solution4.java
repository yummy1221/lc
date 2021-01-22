import java.io.*;
import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;


public class Solution4 {
    
    // Used to calculate the offset.
    public static final int[][] offset = new int[][] {{-2, -1}, {2, -1}, {-2, 1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
    public static final int NUMBER_OF_OFFSETS = 8;
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        // No board case.
        if (m <= 0 || n <= 0) {
            return;
        }
        
        // Starting point and end point.
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();
        
        int noOfBlocks = scanner.nextInt();
        // It is initialized to zero.
        // Block has a value of -1.
        int[][] board = new int[m][n];
        for (int i = 0; i < noOfBlocks; i++) {
            int bx = scanner.nextInt();
            int by = scanner.nextInt();
            board[bx][by] = -1;
        }
        
        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();
        
        q1.add(new int[] {startX, startY});
        // Distance of each level.
        // Start point is initialized to distance 1 to differentiate from 0s.
        int dist = 1;
        while (!q1.isEmpty()) {
            int[] cord = q1.poll();
            int x = cord[0];
            int y = cord[1];
            // End point reached.
            if (x == endX && y == endY) {
                System.out.println(dist - 1);
                return;
            }
            int value = board[x][y];
            if (value == 0) {
                board[x][y] = dist;
                for (int i = 0; i < NUMBER_OF_OFFSETS; i++) {
                    int newX = x + offset[i][0];
                    int newY = y + offset[i][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        q2.add(new int[] {newX, newY});
                    }
                }
            }
            // For value of -1 or it has been visited before, that is to say has a non zero value.
            // Simply ignore it.
            
            // End of one level, swap the two queues and increase the distance.
            if (q1.isEmpty()) {
                dist++;
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;
            }
        }
        
        // Unreachable statement logically. Put here for safe.
        System.out.println(board[endX][endY] - 1);
    }
}