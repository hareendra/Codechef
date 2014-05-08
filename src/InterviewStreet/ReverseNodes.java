package InterviewStreet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class ReverseNodes {

    static class Node {
        public Node next;
        public int data;

        public Node(int data) {
            this.data = data;
        }

        public void printLinkedList() {
            Node head = this;
            while (head.next != null) {
                System.out.print(head.data + "->");
                head = head.next;
            }
            System.out.print(head.data + "->null");
            System.out.println();
        }

    }

    private static Node reverseKLinkedList (Node head, int k)    {
        Node current = head;
        Node next=null;
        Node prev = null;
        int count = 0;

        /*reverse first k nodes of the linked list */
        while (current != null && count < k)
        {
            next  = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        /* next is now a pointer to (k+1)th node
        Recursively call for the list starting from current.
        And make rest of the list as next of first node */
        if(next !=  null)
        {  head.next = reverseKLinkedList(next, k); }

        /* prev is new head of the input list */
        return prev;
    }

    //Works only when the node is not tail node
    private static boolean deleteNode(Node node)   {
        if (node == null || node.next == null)
            return false;

        node.data=node.next.data;
        node.next=node.next.next;
        return true;
    }

    public static void main(String[] args) {
        int k = 9;
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        a.printLinkedList();
        //Node head = reverseKLinkedList(a, k);
        deleteNode(d);
        a.printLinkedList();
    }
}