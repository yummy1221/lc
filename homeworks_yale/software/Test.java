package software;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
// SAT solver DPLL algorithm
public class Test {
	
	public static void main(String[]args) throws FileNotFoundException {
		long startTime = System.currentTimeMillis();
		String filename = "/Users/xiaoyi/Documents/Fall 2015/Software " 
				+ "Analysis and Verification/Homework/Project 2/test case/t12.txt";
		SATSolver t = new SATSolver();
		t.satSolver(filename);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime+"ms");
		System.out.println(totalTime/1000+"s");
	}
}
