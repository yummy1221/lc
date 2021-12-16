package jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Qumulo Phone Interview
public class Qumulo {
	public static void range(int[] arr) {
		Arrays.sort(arr);
		int len = arr.length;
		if(len == 0) return;
		int start = arr[0], end = arr[0];
		for(int i = 1; i < len; i++) {
			if(arr[i] <= end) {
				continue;
			} else if(arr[i] == end + 1) {
				end++;
			} else {
				if(start != end)
					System.out.println(start + " - " + end);
				else
					System.out.println(start);
				start = arr[i];
				end = arr[i];
			}
		}
		if(start != end)
			System.out.println(start + " - " + end);
		else
			System.out.println(start);
	}
	
	public static int minTime(char[][] maze, int[] person, int[] fire) {
		int row = maze.length;
		if(row == 0) return 0;
		int column = maze[0].length;
		int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		
		LinkedList<int[]> q_person = new LinkedList<>();
		q_person.add(person);
		LinkedList<int[]> q_fire = new LinkedList<>();
		q_fire.add(fire);
		int x = 0, y = 0;
		int q_fire_length = 0, q_person_length = 0;
		int counter = 0;	// how much time it takes to go out.
		int[] tmp;
		while(true) {
			counter++;
			// let fire go first
			q_fire_length = q_fire.size();
			for(int i = 0; i < q_fire_length; i++) {
				tmp = q_fire.poll();
				for(int k = 0; k < 4; k++) {
					x = tmp[0] + direction[k][0];
					y = tmp[1] + direction[k][1];
					if(x >= 0 && x < row && y >= 0 && y < column && maze[x][y] != '#' && maze[x][y] != '*') {
						maze[x][y] = '*';
						q_fire.add(new int[]{x, y});
					}
				}
			}
			// let person go then
			q_person_length = q_person.size();
			for(int i = 0; i < q_person_length; i++) {
				tmp = q_person.poll();
				for(int k = 0; k < 4; k++) {
					x = tmp[0] + direction[k][0];
					y = tmp[1] + direction[k][1];
					if(x >= 0 && x < row && y >= 0 && y < column) {
						if(maze[x][y] == '|' || maze[x][y] == '_') {
							return counter;
						} else if(maze[x][y] == ' ') {
							maze[x][y] = '0';
							q_person.add(new int[]{x, y});
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		char[][] maze = {
			"#############".toCharArray(),
			"# @         #".toCharArray(),
			"####  ##### #".toCharArray(),
			"|  #  #   # #".toCharArray(),
			"|  #* #   # #".toCharArray(),
			"|__#______#_|".toCharArray()
		};
		System.out.println(minTime(maze, new int[]{1, 2}, new int[]{4, 4}));
	}
}
