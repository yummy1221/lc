package leetcode;
import java.util.*;
public class Solution166 {
	public static void main(String[]args) {
		int a = -2147483648;
		int b = -1;
		Solution166 s = new Solution166();
		//System.out.println(s.fractionToDecimal(a, b));
		int i = 1;
		System.out.println(i >> 1);
	}
	// corner case : 0 / 3, there is no dot
	// corner case : negative values, -2 / 3
	// corner case : negative 2 / (-3)
	// corner case : -1 / -2147483648, -1/Integer.MIN_VALUE, don't use Math.abs(denominator)
	public String fractionToDecimal(int numerator, int denominator) {
		long num = numerator, den = denominator;
        HashMap<Long, Integer> map =  new HashMap<>();
        int pos = 1;
        if(numerator < 0) pos = pos * (-1);
        if(numerator == 0) pos = pos * 0;
        if(denominator < 0) pos = pos * (-1);
        StringBuilder sb = new StringBuilder();
        long tmp = num / den;
        sb.append(tmp);
        num = num - den * tmp;
        if(num != 0)
            sb.append('.');
        while(num != 0) {
            if(map.containsKey(num)) {
            	tmp = map.get(num);
                sb.insert((int)tmp, '(');
                sb.append(')');
                break;
            }
            map.put(num, sb.length());
            num = num * 10;
            tmp = (int)(num / den);
            sb.append(Math.abs(tmp));
            num = num - den * tmp;
        }
        if(pos == -1 && sb.charAt(0) != '-')
            sb.insert(0, '-');
        return sb.toString();
    }
}
