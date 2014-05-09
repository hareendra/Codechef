package InterviewStreet;

import static java.lang.Math.*;

/**
 * Created by HReddy on 5/9/2014.
 */
public class CountDigits {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            System.out.println(i + " count: " + countdigits(i, 0, 10000));
        }
    }

    private static int countdigits(int d, int low, int high) {
        return countdigits(d, low, high, false);
    }

    private static int countdigits(int d, int low, int high, boolean inner) {
        if (high == 0)
            return (d == 0) ? 1 : 0;

        if (low > 0)
            return countdigits(d, 0, high) - countdigits(d, 0, low);

        int n = (int) floor(log10(high));
        int m = (int) (floor((high + 1) / pow(10, n)));
        int r = high - m * (int) pow(10, n);
        /*
        1. Frequency of any digit up to highest power of 10 (0-99, etc.)
        2. Frequency of MSD above any multiple of highest power of 10 (100-399)
        3. Frequency of any digits in remainder (400-445, R = 45)
        4. Additional frequency of MSD in remainder
        5. Count zeros in middle position for remainder range (404, 405...)
        6. Subtract leading zeros only once (on outermost loop) */

        return (max(m, 1) * n * (int) pow(10, n - 1)) + // (1)
                ((d < m) ? (int) pow(10, n) : 0) + // (2)
                (((r >= 0) && (n > 0)) ? countdigits(d, 0, r, true) : 0) + // (3)
                (((r >= 0) && (d == m)) ? (r + 1) : 0) + // (4)
                (((r >= 0) && (d == 0)) ? countpaddingzeros(n, r) : 0) - // (5)
                (((d == 0) && !inner) ? countleadingzeros(n) : 0); // (6)
    }

    private static int countleadingzeros(int n) {
        return (n == 0) ? 1 : (int) pow(10, n) * countleadingzeros(n - 1);
    }

    private static int countpaddingzeros(int n, int r) {
        return (r + 1) * max(0, n - max(0, (int) floor(log10(r))) - 1);
    }
}