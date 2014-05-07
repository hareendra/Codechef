package InterviewStreet;

/**
 * Created by HReddy on 5/7/2014.
 */

class BinaryTree{
    int data;

    BinaryTree left=null;
    BinaryTree right=null;

    BinaryTree(int data) {
        this.data=data;
    }
}

public class ArrayToBST {
    public static void main(String[] args) {
            int[] arr=new int[]{1,2,3,4,5,6,7};
            BinaryTree bt=convertArraytoBST(arr,0,arr.length-1);
            System.out.println(bt.data);
            System.out.println(bt.left.data);
            System.out.println(bt.right.data);
    }
    public static BinaryTree convertArraytoBST(int[] arr, int start, int end){
        if (start > end) return null;
            // same as (start+end)/2, avoids overflow.
            int mid = start + (end - start) / 2;
            BinaryTree node = new BinaryTree(arr[mid]);
            node.left = convertArraytoBST(arr, start, mid-1);
            node.right = convertArraytoBST(arr, mid+1, end);
            return node;
    }
}
