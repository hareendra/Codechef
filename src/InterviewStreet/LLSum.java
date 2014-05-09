package InterviewStreet;

/**
 * Created by HReddy on 5/9/2014.
 */
public class LLSum {

    private static Node addLists(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
        Node result = new Node(value % 10);
        if (l1 != null || l2 != null) {
            Node more = addLists(l1 == null ? null : l1.right,
                    l2 == null ? null : l2.right,
                    value >= 10 ? 1 : 0);
            result.right=more;
        }
        return result;
    }

    public static int linkedListToInt(Node node) {
        int value = 0;
        if (node.right != null) {
            value = 10 * linkedListToInt(node.right);
        }
        return value + node.data;
    }

    public static Node reverseListIteratively (Node head)
    {
        if (head == null || head.right == null)
            return head;  //empty or just one node in list

        Node Second = head.right;

        //store third node before we change
        Node Third = Second.right;

        //Second's next pointer
        Second.right = head;  //second now points to head
        head.right = null;  //change head pointer to null

        //only two nodes, which we already reversed
        if (Third == null)
            return Second;

        Node CurrentNode = Third;

        Node PreviousNode = Second;

        while (CurrentNode != null)
        {
            Node NextNode = CurrentNode.right;

            CurrentNode.right = PreviousNode;

            /*  repeat the process, but have to reset
                the PreviousNode and CurrentNode */

            PreviousNode = CurrentNode;
            CurrentNode = NextNode;
        }

        head  = PreviousNode; //reset the head node

        return head;
    }


    public static void main(String[] args) {
        Node lA1 = new Node(9);
        Node lA2 = new Node(9);
        Node lA3 = new Node(8);

        lA1.right=lA2;
        lA2.right=lA3;

        Node lB1 = new Node(8);
        Node lB2 = new Node(8);
        Node lB3 = new Node(8);

        lB1.right=lB2;
        lB2.right=lB3;

        /*-------------- When lists are same
        System.out.println(" " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        Node list3 = addLists( reverseListIteratively(lA1), reverseListIteratively(lB1), 0);
        System.out.println("= " + reverseListIteratively(list3).printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));  */

        //--When lists are reverse
        Node list3 = addLists( lA1, lB1, 0);

        System.out.println(" " + lA1.printForward());
        System.out.println("+ " + lB1.printForward());
        System.out.println("= " + list3.printForward());

        int l1 = linkedListToInt(lA1);
        int l2 = linkedListToInt(lB1);
        int l3 = linkedListToInt(list3);

        System.out.print(l1 + " + " + l2 + " = " + l3 + "\n");
        System.out.print(l1 + " + " + l2 + " = " + (l1 + l2));


    }
}
