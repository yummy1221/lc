import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution2 {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scanner = new Scanner(System.in);
    List<Integer> data = new ArrayList<Integer>(10000);
    while (scanner.hasNextLine()) {
        data.add(Integer.parseInt(scanner.nextLine()));
    }        
    
    int size = data.size();
    // Only have one node.
    if (size == 1) {
        System.out.println(data.get(0));
        return;
    }
    
    int[] preorder = new int[size];
    // Put list into array for faster processing speed on large data set.
    for (int i = 0; i < size; i++) {
        preorder[i] = data.get(i);
    }
    // Copy preorder into inorder array.
    int[] inorder = new int[size];
    System.arraycopy(preorder, 0, inorder, 0, size);
    // Sort it to be the result of inorder traversal.
    Arrays.sort(inorder);
    
    // Get postorder traversal from preorder and inorder.
    postOrder(preorder, 0, size - 1, inorder, 0, size - 1);
}
    
    public static void postOrder(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // Base case.
        if (pStart > pEnd) {
            return;
        } else if (pStart == pEnd) {
            // Case of only one element.
            // Just print it out.
            System.out.println(preorder[pEnd]);
            return;
        }
        
        // Current root node of the tree.
        int pivot = preorder[pStart];
        // inorder array is sorted. We could use binary tree.
        int index = Arrays.binarySearch(inorder, iStart, iEnd + 1, pivot);
        
        // Number of elements in the left.
        int leftNo = index - iStart;
        // Number of elements in the right.
        int rightNo = iEnd - index;
        
        // Left Hand Side.
        postOrder(preorder, pStart + 1, pStart + 1 + leftNo - 1, inorder, iStart, index - 1);
        // Right Hand Side.
        postOrder(preorder, pStart + 1 + leftNo, pEnd, inorder, index + 1, iEnd);
        // Post order.
        System.out.println(pivot);
    }
}