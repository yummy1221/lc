import java.util.*;
public class Qumulo {
	public static void main(String[]args) {
		// Qumulo q = new Qumulo();
		String s = "+ 1 * 2 3";
		System.out.println(toInfix(s));
	}
	public static String toInfix(String pre) {
		String[] expr = pre.split(" ");
		int len = expr.length;
		Stack<String> stack = new Stack<>();
		Set<String> operators = new HashSet<>();
		operators.add("+"); operators.add("-");
		operators.add("*"); operators.add("/");
		String op1, op2;
		for(int i = len - 1; i >= 0; i--) {
			if(operators.contains(expr[i])) { // is opertor
				op1 = stack.pop();
				op2 = stack.pop();
				stack.push("("+op1+expr[i]+op2+")");
			} else {
				stack.push(expr[i]);
			}
		}
		return stack.pop();
	}
	
	public static double evaluate(String s) {
		String[] expr = s.split(" ");
		int len = expr.length;
		Stack<Double> stack = new Stack<>();
		Set<String> operators = new HashSet<>();
		operators.add("+"); operators.add("-");
		operators.add("*"); operators.add("/");
		double tmp = 0.0;
		double op1 = 0.0, op2 = 0.0;
		for(int i = len - 1; i >= 0; i--) {
			if(operators.contains(expr[i])) { // is opertor
				op1 = stack.pop();
				op2 = stack.pop();
				switch(expr[i]) {
				case "+" : stack.push(op1 + op2); break; 
				case "-" : stack.push(op1 - op2); break;
				case "*" : stack.push(op1 * op2); break;
				case "/" : stack.push(op1 / op2); break;
				}
			} else {
				tmp = Double.parseDouble(expr[i]);
				stack.push(tmp);
			}
		}
		return stack.pop();
	}
}
