
public class Solution278 {
	public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        long low = 1, high = n;
        int mid;
        while(low < high) {
            mid = (int)((low + high) / 2);
            if(isBadVersion(mid)) {
                //if(!isBadVersion(mid-1)) return mid;
                //else high = mid - 1;
            	high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }
	
	public boolean isBadVersion(int i) {
		return (i >= 1702766719);
	}
	
	public static void main(String[]args) {
		//Solution278 a = new Solution278();
		//System.out.println(a.firstBadVersion(2126753390));
		StringBuilder sb = new StringBuilder();
		sb.append("hello");
		sb.delete(1, 3);
		System.out.println(sb.toString());
	}
}
