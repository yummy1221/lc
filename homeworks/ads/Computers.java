package ads;

import java.util.ArrayList;

// This class contains the computer information about 11 different categories of computers
public class Computers {
	// function like a database, store all the information about existing Computers.
	private ArrayList<PCInfo> computers;
	
	public Computers() {
		computers = new ArrayList<PCInfo>();
		// Apple brand
		PCInfo pc0 = new PCInfo();
		pc0.name = "Macbook by Apple";
		pc0.nums = 2;
		pc0.price = new double[]{1299, 1599};
		pc0.system = 1;
		pc0.type = 1;
		pc0.brand = 1;
		pc0.weight = new double[]{2.03, 2.03};
		pc0.memory = new int[]{8, 8};
		pc0.screen = new double[]{12, 12};
		pc0.disk = new int[]{256, 512};
		pc0.isSSD = true;
		pc0.fun = new Functionality(1,2,2,3,3,1,2,1);
		pc0.exp = "Macbook is a relatively new product of Apple Inc. It is very thin and light,\n"
				+ "which makes it easier to carry around. With Mac OS system, it is no double\n"
				+ " a good product for browsing web pages and has long battery life.However, \n"
				+ "since it has only one port, sometimes it is not easy to expand. Besides, \n"
				+ "it's keyboard may be not comfort when typing for a long time.";
		computers.add(pc0);
		
		PCInfo pc1 = new PCInfo();
		pc1.name = "Macbook Pro by Apple";
		pc1.nums = 5;
		pc1.price = new double[]{1299, 1499, 1799, 1999, 2499};
		pc1.system = 1;
		pc1.type = 1;
		pc1.brand = 1;
		pc1.weight = new double[]{3.48, 3.48, 3.48, 4.49, 4.49};
		pc1.memory = new int[]{8, 8, 8, 16, 16};
		pc1.screen = new double[]{13, 13, 13, 15, 15};
		pc1.disk = new int[]{128, 256, 512, 256, 512};
		pc1.isSSD = true;
		pc1.fun = new Functionality(2,2,1,3,1,2,3,1);
		pc1.exp = "Macbook Pro is an excellent laptop, long lasting battery, convient pre-\n"
				+ "installed softwares, and with retina display, it is perfect for photo or \n"
				+ "video editing projects, and it is much lighter than ordinary laptop. However,\n"
				+ " it may not be satisfying when watching videos and playing games";
		computers.add(pc1);
		
		PCInfo pc2 = new PCInfo();
		pc2.name = "Macbook Air by Apple";
		pc2.nums = 4;
		pc2.price = new double[]{899, 1099, 999, 1199};
		pc2.system = 1;
		pc2.type = 1;
		pc2.brand = 1;
		pc2.weight = new double[]{2.38, 2.38, 2.96, 2.96};
		pc2.memory = new int[]{4, 4, 4, 4};
		pc2.screen = new double[]{11, 11, 13, 13};
		pc2.disk = new int[]{128, 256, 128, 256};
		pc2.isSSD = true;
		pc2.fun = new Functionality(2,1,1,3,2,2,3,1);
		pc2.exp = "Macbook Air is a lighter version of Macbook Pro, very easy to carry around,\n"
				+ " though it may not be that efficient compared with other laptops, it is very \n"
				+ "good at carrying out office works and has long lasting battery life.";
		computers.add(pc2);
		
		PCInfo pc3 = new PCInfo();
		pc3.name = "iMac by Apple";
		pc3.nums = 4;
		pc3.price = new double[]{1499, 1799, 1999, 2299};
		pc3.system = 1;
		pc3.type = 0;
		pc3.brand = 1;
		pc3.weight = new double[]{12.5, 21, 21, 21};
		pc3.memory = new int[]{8, 8, 8, 8};
		pc3.screen = new double[]{21.5, 27, 27, 27};
		pc3.disk = new int[]{1024, 1024, 1024, 2014};
		pc3.isSSD = false;
		pc3.fun = new Functionality(3,2,1,1,1,2,2,3);
		pc3.exp = "iMac is a wonderful desktop, with retina display, it has high resolution \n"
				+ "display. And its big screen makes it a wonderful experience to watch videos\n"
				+ " and enjoy editing photos or videos";
		computers.add(pc3);
		
		PCInfo pc4 = new PCInfo();
		pc4.name = "iPad Air by Apple";
		pc4.nums = 3;
		pc4.price = new double[]{499, 599, 699};
		pc4.system = 1;
		pc4.type = 2;
		pc4.brand = 1;
		pc4.weight = new double[]{0.97, 0.97, 0.97};
		pc4.memory = new int[]{0, 0, 0};
		pc4.screen = new double[]{9.7, 9.7, 9.7};
		pc4.disk = new int[]{16, 64, 128};
		pc4.isSSD = true;
		pc4.fun = new Functionality(2,2,3,1,3,1,1,2);
		pc4.exp = "A very popular tablet, and there are many games on its store, using it to read\n"
				+ " books and watch video is a wonderful experience. It is thin and light and \n"
				+ "can lasts more than 10 hours before recharging. Besides, its camera is a good \n"
				+ "supplement when you suddenly wants to take videos or photos.";
		computers.add(pc4);
		
		// Lenovo Brand
		PCInfo pc5 = new PCInfo();
		pc5.name = "ThinkPad T450s by Lenovo";
		pc5.nums = 1;
		pc5.price = new double[]{974.25};
		pc5.system = 0;
		pc5.type = 1;
		pc5.brand = 2;
		pc5.weight = new double[]{3.5};
		pc5.memory = new int[]{8};
		pc5.screen = new double[]{14};
		pc5.disk = new int[]{500};
		pc5.isSSD = false;
		pc5.fun = new Functionality(1,1,3,2,1,2,2,3);
		pc5.exp = "The black laptop is famous for its office working function and its look is so\n"
				+ " elegent, and it is a wonderful tool for programming with a nice keyboard. Though\n"
				+ " it is a littly heavy compared with other laptops.";
		computers.add(pc5);
		
		
		PCInfo pc6 = new PCInfo();
		pc6.name = "Surface by Microsoft";
		pc6.nums = 3;
		pc6.price = new double[]{899, 1299, 1799};
		pc6.system = 0;
		pc6.type = 2;
		pc6.brand = 0;
		pc6.weight = new double[]{1.73, 1.73, 1.73};
		pc6.memory = new int[]{4, 8, 16};
		pc6.screen = new double[]{12.3, 12.3, 12.3};
		pc6.disk = new int[]{128, 256, 256};
		pc6.isSSD = true;
		pc6.fun = new Functionality(1,1,3,2,3,1,2,2);
		pc6.exp = "Developed by Microsoft, it uses Windows system, and can be used as a \n"
				+ "normal laptop, flexible and light-weighted, it is loved by people \n"
				+ "who need to carry their laptops a lot, though it sometimes performs not\n"
				+ " very well on large tasks.";
		computers.add(pc6);
		
		PCInfo pc7 = new PCInfo();
		pc7.name = "Space Saving Family PC by Lenovo";
		pc7.nums = 1;
		pc7.price = new double[]{699.99};
		pc7.system = 0;
		pc7.type = 0;
		pc7.brand = 2;
		pc7.weight = new double[]{14.76};
		pc7.memory = new int[]{8};
		pc7.screen = new double[]{23};
		pc7.disk = new int[]{1024};
		pc7.isSSD = false;
		pc7.fun = new Functionality(1,2,3,3,1,2,1,2);
		pc7.exp = "An excellent desktop developed by Lenovo, it works well on storing large \n"
				+ "amounts of data, and very suitable for office work. What's more attracting\n"
				+ " is it is very cheap with such good configuration";
		computers.add(pc7);
		
		PCInfo pc8 = new PCInfo();
		pc8.name = "Alienware PC without SSD by Dell";
		pc8.nums = 4;
		pc8.price = new double[]{899.99, 1149.99, 1099.99, 1299.99};
		pc8.system = 0;
		pc8.type = 1;
		pc8.brand = 3;
		pc8.weight = new double[]{4.54, 4.54, 7.07, 7.07};
		pc8.memory = new int[]{4, 8, 8, 8};
		pc8.screen = new double[]{13, 13, 15, 15};
		pc8.disk = new int[]{500, 500, 1024, 2048};
		pc8.isSSD = false;
		pc8.fun = new Functionality(3,3,2,1,2,2,1,1);
		pc8.exp = "Famous among people who love playing games, it has excellent amplified graphics \n"
				+ " and dual channel will surely gives you an unfortable experience for playing games\n"
				+ " and watching videos";
		computers.add(pc8);
		
		PCInfo pc9 = new PCInfo();
		pc9.name = "Alienware PC with SSD by Dell";
		pc9.nums = 4;
		pc9.price = new double[]{1299.99, 1399.99, 1549.99, 1849.99};
		pc9.system = 0;
		pc9.type = 1;
		pc9.brand = 3;
		pc9.weight = new double[]{4.54, 4.54, 7.07, 7.07};
		pc9.memory = new int[]{4, 8, 8, 8};
		pc9.screen = new double[]{13, 13, 15, 15};
		pc9.disk = new int[]{256, 256, 1024, 1024};
		pc9.isSSD = false;
		pc9.fun = new Functionality(3,3,2,1,2,1,1,2);
		pc9.exp = "Famous among people who love playing games, it has excellent amplified graphics \n"
				+ " and dual channel will surely gives you an unfortable experience for playing games\n"
				+ " and watching videos";
		computers.add(pc9);
		
		PCInfo pc10 = new PCInfo();
		pc10.name = "Inspiration 5000 by Dell";
		pc10.nums = 2;
		pc10.price = new double[]{349.99, 549.99};
		pc10.system = 0;
		pc10.type = 1;
		pc10.brand = 3;
		pc10.weight = new double[]{5.11, 5.11};
		pc10.memory = new int[]{4, 8};
		pc10.screen = new double[]{15.6, 15.6};
		pc10.disk = new int[]{500, 1024};
		pc10.isSSD = false;
		pc10.fun = new Functionality(1,1,3,2,1,2,2,3);
		pc10.exp = "One of Dell's most welcomed laptop family, good screen display and audio\n"
				+ " display with relatively low price";
		computers.add(pc10);
		
		PCInfo pc11 = new PCInfo();
		pc11.name = "Macbook Pro by Apple";
		pc11.nums = 1;
		pc11.price = new double[]{1099};
		pc11.system = 1;
		pc11.type = 1;
		pc11.brand = 1;
		pc11.weight = new double[]{3.48};
		pc11.memory = new int[]{4};
		pc11.screen = new double[]{13};
		pc11.disk = new int[]{500};
		pc11.isSSD = false;
		pc11.fun = new Functionality(2,2,1,3,1,2,3,1);
		pc11.exp = "Macbook Pro is an excellent laptop, long lasting battery, convient pre-\n"
				+ "installed softwares, and with retina display, it is perfect for photo or \n"
				+ "video editing projects, and it is much lighter than ordinary laptop. However,\n"
				+ " it may not be satisfying when watching videos and playing games";
		computers.add(pc11);
	}
	
	public ArrayList<PCInfo> getComputers() {
		return this.computers;
	}
}