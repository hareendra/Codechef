package InterviewStreet;

/**
 * Created by HReddy on 5/7/2014.
 */

public class BTToLinkedList {
    static Node binTreeToDoublyLLUtil(Node root)
    {
        // Base case
        if (root == null)
            return root;

        // Convert the left subtree and link to root
        if (root.left != null)
        {
            // Convert the left subtree
            Node left = binTreeToDoublyLLUtil(root.left);
            // Find inorder predecessor. After this loop, left
            // will point to the inorder predecessor
            for (; left.right!=null; left=left.right);
            // Make root as next of the predecessor
            left.right = root;
            // Make predecssor as previous of root
            root.left = left;
        }

        // Convert the right subtree and link to root
        if (root.right!=null)
        {
            // Convert the right subtree
            Node right = binTreeToDoublyLLUtil(root.right);

            // Find inorder successor. After this loop, right
            // will point to the inorder successor
            for (; right.left!=null; right = right.left);

            // Make root as previous of successor
            right.left = root;
            // Make successor as next of root
            root.right = right;
        }

        return root;
    }

    static Node binTreeToDoublyLL(Node root)
    {
        // Base case
        if (root == null)
            return root;

        // Convert to DLL using binTreeToDoublyLLUtil()
        root = binTreeToDoublyLLUtil(root);

        // binTreeToDoublyLLUtil() returns root node of the converted
        // DLL.  We need pointer to the leftmost node which is
        // head of the constructed DLL, so move to the leftmost node
        while (root.left != null)
            root = root.left;

        return (root);
    }

    /* Function to print nodes in a given doubly linked list */
    static void printList(Node node)
    {
        while (node!=null)
        {
            System.out.printf("%d ", node.data);
            node = node.right;
        }
    }


    /* Driver program to test above functions*/
    public static void main(String[] args)
    {
        // Let us create the tree shown in above diagram
        Node root       = new Node(10);
        root.left       = new Node(12);
        root.right      = new Node(15);
        root.left.left  = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        // Convert to DLL
        Node head = binTreeToDoublyLL(root);

        // Print the converted list
        printList(head);

        return ;
    }
}
     
