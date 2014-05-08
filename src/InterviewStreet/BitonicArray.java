package InterviewStreet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class BitonicArray {
    public static void main(String[] args)  {
        System.out.println(find_max(new int[]{1,2,3,2,1},4));
    }

    private static int find_max(int[] array, int size)      {
        int low_bound, mid, low, high;
        low_bound = low = 0;
        high = size - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (mid == low_bound) {
                        /* Only one element */
                if (mid == high)
                    return mid;
                else    /* 2 elements in increasing order */
                    return mid + 1;
            }
            if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1])
                low = mid + 1;
            else if (array[mid - 1] > array[mid] && array[mid] > array[mid + 1])
                high = mid - 1;
            else /* max value found */
                return mid;
        }
        return -1;
    }
}
