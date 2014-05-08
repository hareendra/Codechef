package InterviewStreet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by HReddy on 5/8/2014.
 */
public class LevelSumDiff {
    // An iterative method to find difference between
    static int getLevelDiff(Node root)      {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<Node>();
        Node temp = root;

        int level = 1, oddLevel_sum, evenLevel_sum;
        oddLevel_sum = evenLevel_sum = 0;

        // A null value is used as a separator between two levels
        queue.offer(root);
        queue.offer(null);

        // Do a level order traversal
        while (!queue.isEmpty())        {
            temp = queue.poll();

            // If this node is null, a new level is going to start
            if (temp == null)            {
                // increment level number
                level++;
                // insert a seperator if queue is not empty
                if (!queue.isEmpty())
                     queue.offer(null);
            }
            else  {// If this is from same level as previous node
                if (level %2== 1)
                    oddLevel_sum += temp.data;
                else
                    evenLevel_sum += temp.data;
                if (temp.left!=null)
                    queue.offer(temp.left);
                if (temp.right!=null)
                    queue.offer(temp.right);
            }
        }
        return (oddLevel_sum - evenLevel_sum);
    }

    public static void main(String[] args)      {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left  = new Node(1);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.right.right = new Node(8);
        root.right.right.right = new Node(9);
        root.right.right.left = new Node(7);
        System.out.printf("%d is the required difference\n",getLevelDiff(root));
        return;
    }
}
