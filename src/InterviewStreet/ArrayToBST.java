package InterviewStreet;

/**
 * Created by HReddy on 5/7/2014.
 */

public class ArrayToBST {
    public static void main(String[] args) {
            int[] arr=new int[]{1,2,3,4,5,6,7};
            Node bt=convertArraytoBST(arr,0,arr.length-1);
            System.out.println(bt.data);
            System.out.println(bt.left.data);
            System.out.println(bt.right.data);
    }
    public static Node convertArraytoBST(int[] arr, int start, int end){
        if (start > end) return null;
            // same as (start+end)/2, avoids overflow.
            int mid = start + (end - start) / 2;
            Node node = new Node(arr[mid]);
            node.left = convertArraytoBST(arr, start, mid-1);
            node.right = convertArraytoBST(arr, mid+1, end);
            return node;
    }
}
