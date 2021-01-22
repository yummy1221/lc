package ads;

import java.util.ArrayList;
import java.util.Scanner;

public class PCAdvisor {
	private static Scanner stdin;
	
	private static void compare(ArrayList<PCInfo> recommendations) {
		int len = recommendations.size();
		if(len == 0) {
			System.out.println("Sorry, we don't have a recommendation for you now, "
					+ "please try again!!!");
			return;
		}
		int[] scores = new int[len];
		String tmp = "";
		System.out.println("What kind of activities would you like to do with your computer,");
		System.out.println("1. browsing web pages");
		System.out.println("2. office work like word, speedsheet and managing emails");
		System.out.println("3. editing photos or videos");
		System.out.println("4. playing games");
		System.out.println("5. programming");
		System.out.println("6. connecting with friends and other social works");
		System.out.println("7. watching TV series or movies");
		System.out.println("8. lasting for a long time with battery");
		
		System.out.println("Choose the most important three separated by space");
		System.out.print("Your Choice: ");
		tmp = stdin.nextLine();
		while(!tmp.matches("[1-8]\\s+[1-8]\\s+[1-8]")) {
			System.out.println("Please enter three choices in format like : 1 2 3(Do not include space at the beginning)");
			tmp = stdin.nextLine();
		}
		String[] activity = tmp.split("\\s+");
		int[] activities = new int[3];
		for(int i = 0; i < 3; i++) {
			activities[i] = Integer.parseInt(activity[i]) - 1;
		}
		
		int result = 0;
		int min = len * 10;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < 3; j++) {
				scores[i] += recommendations.get(i).fun.functions[activities[j]];
			}
			if(scores[i] < min) {
				min = scores[i];
				result = i;
			}
		}
		
		// Then choose disk size and prices
		show(recommendations.get(result));
	}
	
	private static void show(PCInfo pc) {
		if(pc == null) {
			System.out.println("Sorry, we don't have a recommendation for you now, "
					+ "please try again!!!");
		}
		int disk = 0;
		int memory = 0;
		double screen = 0.0;
		int index = 0;
		if(pc.nums > 1) {
			System.out.print("What is the expected disk size(integer): ");
			disk = stdin.nextInt();
			System.out.print("What is the expected memory size(integer): ");
			memory = stdin.nextInt();
			System.out.print("What is the expected screen size(integer): ");
			screen = stdin.nextDouble();
			// calculate distance
			double min = Double.MAX_VALUE; 
			double score = 0.0;
			if(pc.nums > 1) {
				for(int i = 0; i < pc.nums; i++) {
					score = Math.abs(pc.memory[i] - memory)/(double)pc.memory[i];
					score += Math.abs(pc.disk[i] - disk)/(double)pc.disk[i];
					score += Math.abs(pc.screen[i] - screen)/pc.screen[i];
					if(score < min) {
						min = score;
						index = i;
					}
				}
			}
		}

		// Time to show result
		System.out.println("According to the information you provide, the computer");
		System.out.println("that I recommend to you is \"" + pc.name + "\" with the following configuration:");
		System.out.println("Disk Size: " + pc.disk[index] + "G");
		System.out.println("Memory Size: " + pc.memory[index] + "G");
		System.out.println("Screen Size: " + pc.screen[index] + " inch");
		System.out.println("Weight: " + pc.weight[index] + "lbs");
		System.out.println("Price: $" + pc.price[index]);
		System.out.println(pc.exp);
	}

	public static void main(String[]args) {
		
		stdin = new Scanner(System.in);
		
		welcome();
		
		// The recommended computers
		ArrayList<PCInfo> recommendations = new ArrayList<PCInfo>(new Computers().getComputers());
		
		// Choose a Operating System
		int a = chooseSystem(recommendations);
		
		
		// Choose a Brand
		if(recommendations.size() > 1 && a == 0)
			chooseBrand(recommendations);
		
		// Choose a Type
		if(recommendations.size() > 1)
			chooseType(recommendations);
		
		// SSD or not
		if(recommendations.size() > 1)
			isSSD(recommendations);
		
		// target compare
		compare(recommendations);
		
		System.out.println("Hope you would like our recommendation");
		System.out.println("Thank you for using our system and have a nice day~");
	}
	
	private static void welcome() {
		String name;
		boolean gender = false;		// false - male, true - female
		System.out.println("Welcome to PC advisor system\nThis is a magic system "
				+ "that will recommend the computers that best fits your needs~");
		
		System.out.println("To begin with, Tell me something about you!");
		System.out.print("What should I call you: ");
		name = stdin.nextLine();
		System.out.println("and gender(m or f?): ");
		if(stdin.nextLine().contains("f"))
			gender = true;
		System.out.print("Hello ");
		if(gender)
			System.out.print("Ms. ");
		else
			System.out.print("Mr. ");
		System.out.println(name + ", welcome, now let's begin asking some questions!");

	}
	private static void isSSD(ArrayList<PCInfo> recommendations) {
		String tmp;
		int choice = 0;
		System.out.println("Considering the situation you would use your computer,");
		System.out.println("Do you want to have Solid State Disk(SSD) for your computer?");
		System.out.println("1. I need SSD\n2. Hard Disk Drive works fine with me\n"
				+ "3. Either is OK with me");
		tmp = stdin.nextLine();
		while(!tmp.matches("[123]")) {
			System.out.println("Please enter 1, 2 or 3");
			tmp = stdin.nextLine();
		}
		choice = Integer.parseInt(tmp);
		boolean ssd = false;
		if(choice == 1) ssd = true;
		if(choice != 3) {
			for(int i = 0; i < recommendations.size(); i++) {
				if(recommendations.get(i).isSSD != ssd) {
					recommendations.remove(i);
					i--;
				}
			}
		}
	}
	
	private static void chooseType(ArrayList<PCInfo> recommendations) {
		String tmp;
		int choice = 0;
		System.out.println("Considering the situation you would use your computer,");
		System.out.println("What kind of computer you would like to buy?");
		System.out.println("1. Desktop\n2. Laptop\n3. Tablet\n4. don't care");
		tmp = stdin.nextLine();
		while(!tmp.matches("[1234]")) {
			System.out.println("Please enter 1, 2, 3, 4");
			tmp = stdin.nextLine();
		}
		choice = Integer.parseInt(tmp);
		choice--;
		if(choice != 3) {
			for(int i = 0; i < recommendations.size(); i++) {
				if(recommendations.get(i).type != choice) {
					recommendations.remove(i);
					i--;
				}
			}
		}
	}
	
	private static int chooseSystem(ArrayList<PCInfo> recommendations) {
		String tmp;
		int result = 0;
		int choice = 0;
		System.out.println("What is the system that you are most familar with?");
		System.out.println("1. Mac OS\n2. Windows\n3. Linux\n4. don't care");
		tmp = stdin.nextLine();
		while(!tmp.matches("[1234]")) {
			System.out.println("Please enter 1, 2, 3, 4");
			tmp = stdin.nextLine();
		}
		choice = Integer.parseInt(tmp);
		if(choice == 1) result = 1;
		if(choice != 4) {
			if(choice != 1) choice = 0;
			for(int i = 0; i < recommendations.size(); i++) {
				if(recommendations.get(i).system != choice) {
					recommendations.remove(i);
					i--;
				}
			}
		}
		return result;
	}
	
	private static void chooseBrand(ArrayList<PCInfo> recommendations) {
		String tmp;
		int choice = 0;
		System.out.println("Is there a particular computer brand that you would like?");
		System.out.println("1. Apple\n2. Lenovo\n3. Dell\n4. other\n5. don't care");
		tmp = stdin.nextLine();
		while(!tmp.matches("[12345]")) {
			System.out.println("Please enter 1, 2, 3, 4");
			tmp = stdin.nextLine();
		}
		choice = Integer.parseInt(tmp);
		if(choice != 5) {
			if(choice == 4) choice = 0;
			for(int i = 0; i < recommendations.size(); i++) {
				if(recommendations.get(i).brand != choice) {
					recommendations.remove(i);
					i--;
				}
			}
		}
	}
}