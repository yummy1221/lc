import java.util.Arrays;

public class preToPost {
	public static void main(String[]args) {
		int[] pre = {2,1,3};
		int[] in = pre.clone();
		Arrays.sort(in);
		int len = pre.length;
		int[] post = new int[len];
		preToPost1(0, len-1, 0, len-1, pre, post, in);
		for(int i : post)
			System.out.println(i);
	}
	public static void preToPost1(int pre_begin, int pre_end, int in_begin, int post_end, int[]pre, int[]post, int[]in) {
		int index = 0;
		int len = pre_end - pre_begin + 1;
		if(len <= 0) return;
		if(len == 1) {
			post[post_end] = pre[pre_begin];
			return;
		}
		for(int i = in_begin; i < in_begin+len; i++) {
			if(in[i] == pre[pre_begin]) {
				index = i;
				break;
			}
		}
		post[post_end] = pre[pre_begin];
		int left_len = index - in_begin;
		int right_len = len - left_len - 1;
		
		// left tree
		preToPost1(pre_begin+1, pre_begin+left_len, in_begin, post_end-right_len-1, pre, post, in);
		// right tree
		preToPost1(pre_begin+left_len+1, pre_end, index+1, post_end-1, pre, post, in);
	}
}
