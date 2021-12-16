package leetcode;

import java.util.*;

public class Solution252 {
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public static void main(String[]args) {
		Interval[] i = new Interval[10];
		i[0] = new Interval(1, 10);
		i[1] = new Interval(2, 10);
		i[2] = new Interval(6, 10);
		i[3] = new Interval(2, 10);
		i[4] = new Interval(12, 10);
		i[5] = new Interval(121, 10);
		i[6] = new Interval(12, 10);
		i[7] = new Interval(21, 10);
		i[8] = new Interval(15, 10);
		i[9] = new Interval(1, 10);
		Arrays.sort(i, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
			
		});
		for(int j = 0; j < 10; j++)
			System.out.println(i[j].start+" "+i[j].end);
	}
}
