package InterviewStreet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class MergeSortedLists {
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

    static Node MergeLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node head;
        if (list1.data < list2.data) {
            head = list1;
        } else {
            head = list2;
            list2 = list1;
            list1 = head;
        }

        while(list1.next != null && list2 != null) {
            if (list1.next.data > list2.data) {
                Node tmp = list1.next;
                list1.next = list2;
                list2 = tmp;
            }
            list1 = list1.next;
        }

        if (list1.next == null) list1.next = list2;
        return head;
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
        a.next = c;
        b.next = d;
        c.next = e;
        d.next = f;
        e.next = g;
        f.next = h;

        a.printLinkedList();
        b.printLinkedList();
        MergeLists(a,b).printLinkedList();
    }
}
