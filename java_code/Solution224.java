package leetcode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;
public class Solution224 {
	
	public static void main(String[]args) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        // evaluate JavaScript code
        Object result = engine.eval("1*2-3/4+5*6-7*8+9/10");
        System.out.println(result);
        
        System.out.println(calculate("1*2-3/4+5*6-7*8+9/10"));
        

	} 
	
    public static int calculate(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	map.put('+', 1);
    	map.put('-', 1);
    	map.put('*', 0);
    	map.put('/', 0);
        Stack<Character> ops = new Stack<>();
        Stack<Integer> vals = new Stack<>();
        int len = s.length();
        int v1 = 0, v2 = 0;
        char tmp = 0;
        for(int i = 0; i < len; i++) {
            tmp = s.charAt(i);
            if(Character.isDigit(tmp)) {
                v2 = 0;
                while(Character.isDigit(tmp)) {
                    v2 = v2 * 10 + tmp - '0';
                    if(++i == len) break;
                    tmp = s.charAt(i);
                }
                i--;
                vals.push(v2);
            } else if (tmp == '(') {
                ops.push(tmp);
            } else if (tmp == '+' || tmp == '-') {
            	while(!ops.empty() && map.containsKey(ops.peek())) {
            		v2 = vals.pop();
            		v1 = vals.pop();
            		switch(ops.pop()) {
            		case '+': vals.push(v1+v2); break;
            		case '-': vals.push(v1-v2); break;
            		case '*': vals.push(v1*v2); break;
            		case '/': vals.push(v1/v2); break;
            		}
            	} 
            	ops.push(tmp);
            }else if (tmp == '*' || tmp == '/') {
            	while(!ops.empty() && map.get(ops.peek()) == 0) {
            		v2 = vals.pop();
            		v1 = vals.pop();
            		switch(ops.pop()) {
            		case '*': vals.push(v1*v2); break;
            		case '/': vals.push(v1/v2); break;
            		}
            	}
            	ops.push(tmp);
            } else if(tmp == ')') {
                tmp = ops.pop();
                while(tmp != '(') {
                	v2 = vals.pop();
                    v1 = vals.pop();
                    switch(tmp) {
            		case '+': vals.push(v1+v2); break;
            		case '-': vals.push(v1-v2); break;
            		case '*': vals.push(v1*v2); break;
            		case '/': vals.push(v1/v2); break;
            		}
                    tmp = ops.pop();
                }
                while(!ops.empty() && ops.peek() != '(') {
                	tmp = ops.pop();
                	v2 = vals.pop();
                    v1 = vals.pop();
                    switch(tmp) {
            		case '+': vals.push(v1+v2); break;
            		case '-': vals.push(v1-v2); break;
            		case '*': vals.push(v1*v2); break;
            		case '/': vals.push(v1/v2); break;
            		}
                }
            }
        }
        while(!ops.empty()) {
        	tmp = ops.pop();
        	v2 = vals.pop();
            v1 = vals.pop();
            switch(tmp) {
    		case '+': vals.push(v1+v2); break;
    		case '-': vals.push(v1-v2); break;
    		case '*': vals.push(v1*v2); break;
    		case '/': vals.push(v1/v2); break;
    		}
        }
        return vals.pop();
    }
}
	
	