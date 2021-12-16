
// for review of DB final exam
public class testDB {
	public static void main(String[]args) {
		int sum = 0;
		String a = "history";
		for(int i = 0; i < a.length(); i++) {
			sum += a.charAt(i) - 'a' + 1;
		}
		System.out.println(sum % 8);
	}
}
