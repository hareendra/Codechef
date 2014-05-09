package InterviewStreet;

import java.util.Stack;
/**
 * Created by HReddy on 5/9/2014.
 */
public class BTMinMaxElements {
    private static long inOrder(Node root,int value)
    {
      /* set current to root of binary tree */
        Node current = root;
        Stack<Node> s = new Stack<Node>();  /* Initialize stack s */
        boolean done = false;

        long max=Long.MAX_VALUE;

        while (!done)           {
            /* Reach the left most tNode of the current tNode */
            if(current !=  null)           {
            /* place pointer to a tree node on the stack before traversing
                the node's left subtree */
                s.push(current);
                current = current.left;
            }

    /* backtrack from the empty subtree and visit the tNode
       at the top of the stack; however, if the stack is empty,
      you are done */
            else                {
                if (!s.isEmpty())   {
                    current = s.pop();

                    if(current.data>value &&
                            (current.data-value)<(max-value))  {
                        max=current.data;
                    }

                    System.out.printf("%d ", current.data);

        /* we have visited the node and its left subtree.
          Now, it's right subtree's turn */
                    current = current.right;
                }
                else
                    done = true;
            }
        } /* end of while */
        return max;
    }

    public static void main(String[] args)  {
        /* Constructed binary tree is
                        1
                      /   \
                    2      3
                  /  \
                4     5
        */
        Node root       = new Node(1);
        root.left       = new Node(2);
        root.right      = new Node(3);
        root.left.left  = new Node(4);
        root.left.right = new Node(5);

        int value=5;
        long max=inOrder(root,value);
        if(max!=Long.MAX_VALUE)
            System.out.println("\n"+max);
        else
            System.out.println("\nNot found");
        return ;
    }
}
