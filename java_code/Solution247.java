package leetcode;
import java.util.*;

public class Solution247 {
    public static List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        char[] res = new char[n];
        for(int i = 0; i < n; i++) res[i] = ' ';
        int end = 0;
        if(n % 2 == 0) end = n / 2 - 1;
        else end = n / 2;
        strobogrammatic(0, result, res, end);
        return result;
    }
    
    public static void strobogrammatic(int begin, List<String> result, char[] res, int end) {
        int len = res.length;
        if(begin > end) {
            if(res[0] != '0' || len == 1) 
                result.add(new String(res));
            return;
        }
        res[begin] = '0'; res[len-1-begin] = '0';
        strobogrammatic(begin+1, result, res, end);
        res[begin] = '1'; res[len-1-begin] = '1';
        strobogrammatic(begin+1, result, res, end);
        res[begin] = '8'; res[len-1-begin] = '8';
        strobogrammatic(begin+1, result, res, end);
        if(begin != len - 1 - begin) {
            res[begin] = '6'; res[len-1-begin] = '9';
            strobogrammatic(begin+1, result, res, end);
            res[begin] = '9'; res[len-1-begin] = '6';
            strobogrammatic(begin+1, result, res, end);
        }
    }
    
    public static void main(String[]args) {
    	int mid, end, res;
    	for(int a = 1; a <= 10; a++) {
    		//System.out.print(findStrobogrammatic(a).size() + " ");
    		mid = Math.max(a/2-1, 0);
    		end = a % 2;
    		res = 3;
    		if(a > 1) {
        		res = 4 * (int)Math.pow(5, mid) * (int)Math.pow(3, end);
        	}
    		//System.out.println(res);
    	}
    	//System.out.println(findStrobogrammatic(3));
    	String x = "abc", y = "abc";
    	System.out.println(y.compareTo(x));
    	//for(int len = 1; len < 10; len ++)
    	//	System.out.println(len + ": " + (len / 2 - 1 + (len % 2)));
    }
}
