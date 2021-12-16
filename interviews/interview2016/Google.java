package jobs;

import java.util.Stack;

// 11/20/2015 Google Code Sample before phone interview
public class Google {
	public static int solution(int X) {
        // write your code in Java
        String s = X+"";
        int len = s.length();
        char[] c = new char[len+1];
        int index = 0;
        for(int i = 0; i < len; i++) {
            c[index] = s.charAt(i);
            if(i == index && i+1 < len && s.charAt(i) > s.charAt(i+1)) {
                c[++index] = s.charAt(i);
            }
            index++;
        }
        c[len] = s.charAt(len - 1);
        return Integer.parseInt(new String(c));
    }
	
	public static int path(String S) {
        // write your code in Java
        String[] paths = S.split("\n");
        int level = -1;
        int count = 0;
        int length = 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(String i : paths) {
            count = 0;
            while(i.charAt(count) == ' ') count++;
            if(count > level) {
                if(!i.contains(".")) {
                   stack.push(i.length()-count+1); 
                   length += i.length() - count + 1;
                   level = count;
                } else {
                    if(i.contains(".jpeg") || i.contains(".png") || i.contains(".gif")) {
                        if(max < length + i.length() - count)
                            max = length + i.length() - count;
                    }
                }
            } else {
                if(i.contains(".")) continue;
                while(stack.size() > count) {
                    length = length - stack.pop();
                }
                length = length + i.length() - count + 1;
                stack.push(i.length()-count+1);
                level = count;
            }
        }
        return max+1;
    }
	
	public static void main(String[]args) {
		//int a = 112233441;
		//System.out.println(solution(a));
		String b = "dir\n dir1\n  dir11\n  dir12\n   picture.jpeg\n   dir121\n    abcdef.png\n   file1.txt\n dir2\n  file2.gif";
		String ans = "/dir/dir1/dir12/dir121/abcdef.png";
		System.out.println(path(b) + " " + ans.length());
		//System.out.println(b.contains("."));
	}
}
