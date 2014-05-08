package InterviewStreet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class SubArraySum {

    static boolean subArraySum(int arr[], int n, int sum)
    {
    /* Initialize curr_sum as value of first element
       and starting point as 0 */
        int curr_sum = arr[0], start = 0, i;

    /* Add elements one by one to curr_sum and if the curr_sum exceeds the
       sum, then remove starting element */
        for (i = 1; i <= n; i++)                {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > sum && start < i-1)                   {
                curr_sum = curr_sum - arr[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == sum)                    {
                System.out.printf ("Sum found between indexes %d and %d", start, i-1);
                return true;
            }

            // Add this element to curr_sum
            if (i < n)
                curr_sum = curr_sum + arr[i];
        }

        // If we reach here, then no subarray
        System.out.printf("No subarray found");
        return false;
    }

    public static  void main(String[] args) {
        int[] ary=new int[]{1,2,3,5};
        subArraySum(ary,ary.length,5);
    }
}
