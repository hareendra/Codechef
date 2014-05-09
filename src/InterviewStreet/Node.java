package InterviewStreet;

/**
 * Created by HReddy on 5/7/2014.
 */
public  class Node{
    int data;

    Node left=null;
    Node right=null;

    Node(int data) {
        this.data=data;
    }

    public String printForward() {
        if (right != null) {
            return data + "->" + right.printForward();
        } else {
            return ((Integer) data).toString();
        }
    }

}

