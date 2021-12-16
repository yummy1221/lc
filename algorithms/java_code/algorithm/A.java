package algorithm;

public class A implements Comparable<A>{

	private int a;
	public A(int i1) {
		a = i1;
	}
	@Override
	public int compareTo(A o) {
		// TODO Auto-generated method stub
		return this.a - o.a;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a+"";
	}
	
	
	
}
