package InterviewStreet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class ViewOfBT {
    static int max_level=0;

    // Recursive function to print left view of a binary tree.
    static void leftViewUtil(Node root, int level)       {
        // Base Case
        if (root==null)  return;

        // If this is the first node of its level
        if (max_level < level)        {
            System.out.println( root.data+"\t");
            max_level = level;
        }

        // Recur for left and right subtrees
        // If you want right view of subtree traverse right before left
        leftViewUtil(root.left, level+1);
        leftViewUtil(root.right, level+1);
    }

    // A wrapper over leftViewUtil()
    static void leftView(Node root)    {
        max_level = 0;
        leftViewUtil(root, 1);
    }

    // Driver Program to test above functions
    public static  void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(10);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(40);

        leftView(root);
        return ;
    }
}
