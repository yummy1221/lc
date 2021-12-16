package jobs;

import java.util.Scanner;

// date 12/15/2015 Phone Interview
import java.util.HashMap;

public class Bloomberg {
    public static int[] arr = {1,10,5,6,7,4, 9,2};
    public static void main(String[]arg) {
        int len = arr.length;
        int sum = 0;
        Integer[] out;
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                sum = arr[i] + arr[j];
                if(map.containsKey(sum)) {
                    out = map.get(sum);
                    System.out.println("("+arr[i]+", "+arr[j]+"), "+"("+out[0]+", "+out[1]+")");
                    map.remove(sum);
                } else {
                    map.put(sum, new Integer[]{arr[i], arr[j]});
                }
            }
        }
    }
}
