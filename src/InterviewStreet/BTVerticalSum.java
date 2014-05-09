package InterviewStreet;

/**
 * Created by HReddy on 5/9/2014.
 */
import java.util.HashMap;

public class BTVerticalSum {

    // A wrapper over VerticalSumUtil()
    private static void VerticalSum(Node root) {

        // base case
        if (root == null) { return; }

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        // Calls the VerticalSumUtil() to store the vertical sum values in hM
        VerticalSumUtil(root, 0, hM);

        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
            System.out.println(hM.entrySet());
        }
    }

    // Traverses the tree in Inoorder form and builds a hashMap hM that
    // contains the vertical sum
    private static void VerticalSumUtil(Node root, int hD,
                                 HashMap<Integer, Integer> hM) {

        // base case
        if (root == null) {  return; }

        // Store the values in hM for left subtree
        VerticalSumUtil(root.left, hD - 1, hM);

        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.data);

        // Store the values in hM for right subtree
        VerticalSumUtil(root.right, hD + 1, hM);
    }

    public static void main(String[] args) {
        /* Create following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7

        */
        Node root = new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);

        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        System.out.println("Following are the values of vertical sums with "
                + "the positions of the columns with respect to root ");
        VerticalSum(root);
    }
}
