package ads;

public class PCInfo {
	protected String name;	// name of the computer
	protected int nums;		// how many different configurations
	protected double[] price;	// price of this kind of computer
	protected int system;		// Linux & Windows - 0, Mac OS - 1
	// 0 - desktop, 1 - laptop, 2 - tablet
	protected int type;	
	// brand of computer, 1 - Apple, 2 - Lenovo, 3 - Dell, 0 - others
	protected int brand;		
	protected double[] weight;	// unit - lb
	protected int[] memory;
	protected double[] screen;
	protected int[] disk;
	protected String exp;
	protected boolean isSSD;
	protected Functionality fun;
}