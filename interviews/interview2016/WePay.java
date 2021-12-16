package jobs;

import java.util.*;

public class WePay {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++){
                if(j < len - 1- i)
                    System.out.print(" ");
                else
                    System.out.print("#");
            }
            System.out.println();
        }    
    }
}
