package InterviewStreet;

import java.util.Arrays;

/**
 * Created by HReddy on 5/8/2014.
 */
public class DifferenceElements {
    public static void main(String[] args){
        int[] ary=new int[] {1,2,3,-1};
        System.out.println(maxDiff(ary));
        System.out.println(minDiff(ary));
    }

    private static int minDiff(int[] a){
        Arrays.sort(a);
        int minDiff = a[1]-a[0];
        for (int i = 2 ; i != a.length ; i++) {
            minDiff = Math.min(minDiff, a[i]-a[i-1]);
        }

        return minDiff;
    }

    private static int maxDiff (int arr[])
    {
        Arrays.sort(arr);
        return arr[arr.length-1]-arr[0];
    }
}
