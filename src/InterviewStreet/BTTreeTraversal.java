package InterviewStreet;

/**
 * Created by HReddy on 5/9/2014.
 */
public class BTTreeTraversal {

    private static Node buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int preLength = preorder.length;
        int inLength = inorder.length;
        return buildTree(preorder, 0, preLength-1, inorder, 0, inLength-1);
    }

    private static Node buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }
        int rootdata = pre[preStart];
        int rootIndex = 0;

        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == rootdata){
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart;
        Node root = new Node(rootdata);
        root.left = buildTree(pre, preStart+1, preStart+len, in, inStart, rootIndex-1);
        root.right = buildTree(pre, preStart+len+1, preEnd, in, rootIndex+1, inEnd);

        System.out.print(root.data+" ");
        return root;
    }

    // Driver program to test above functions
    public static void main(String[] args)          {
        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] =  {1, 2, 4, 5, 3, 6};
        int n = in.length;
        System.out.println("Postorder traversal ");
        Node n2=buildTree(pre,in);
        return ;
    }
}
