package InterviewStreet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class PallindromicString {
    // A utility function to print a substring str[low..high]
    static void printSubStr(char[] str, int low, int high)
    {
        for( int i = low; i <= high; ++i )
            System.out.printf("%c", str[i]);
    }

    // This function prints the longest palindrome substring (LPS)
    // of str[]. It also returns the length of the longest palindrome
    static int longestPalSubstr(char[] str)
    {
        int maxLength = 1;  // The result (length of LPS)

        int start = 0;
        int len = str.length;

        int low, high;

        // One by one consider every character as center point of
        // even and length palindromes
        for (int i = 1; i < len; ++i)
        {
            // Find the longest even length palindrome with center points
            // as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && str[low] == str[high])
            {
                if (high - low + 1 > maxLength)
                {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with center
            // point as i
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && str[low] == str[high])
            {
                if (high - low + 1 > maxLength)
                {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        System.out.printf("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        System.out.printf("\nLength is: %d\n", longestPalSubstr("forgeeksskeegfor".toCharArray()) );
        return;
    }
}
