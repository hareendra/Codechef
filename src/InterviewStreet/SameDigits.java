package InterviewStreet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class SameDigits {
    public static void main(String pardeep[]) {
            nextHigestNumber(9531);
            nextSmallestNumber(1234);
    }
    private static void nextHigestNumber(int inputInt) {
        char inputStr[] = Integer.toString(inputInt).toCharArray();
        String output = "";
        int pivotIndex = -1, len = inputStr.length, min = 99999999, replaceIndex = -1;

        for (int i = len - 1; i >= 0; i--) {
            if (i == 0) {//if no is already highest
                break;
            }
            if (inputStr[i - 1] < inputStr[i] && i > 0) { //finding pivot element
                pivotIndex = i - 1;
                for (int j = pivotIndex + 1; j < len; j++) { // finding next highest of pivot element
                    int d = inputStr[j] - inputStr[pivotIndex];
                    if (d < min && d > 0) {
                        replaceIndex = j;
                        min = d;
                    }
                }

                //Replacing pivot element with next highest element
                char temp = inputStr[pivotIndex];
                inputStr[pivotIndex] = inputStr[replaceIndex];
                inputStr[replaceIndex] = temp;
                //reversing
                for (i = 0; i <= pivotIndex; i++)
                    output += inputStr[i];
                for (i = len - 1; i > pivotIndex; i--)
                    output += inputStr[i];
                break;
            }
        }
        if (pivotIndex == -1)
            System.out.println("-1");
        else
            System.out.println(output);
    }

    private static void nextSmallestNumber(int inputInt) {
        char inputStr[] = Integer.toString(inputInt).toCharArray();
        String output = "";
        int pivotIndex = -1, len = inputStr.length, min = 99999999, replaceIndex = -1;

        for (int i = len - 1; i >= 0; i--) {
            if (i == 0) {//if no is already highest
                break;
            }
            if (inputStr[i - 1] > inputStr[i] && i > 0) { //finding pivot element
                pivotIndex = i - 1;
                for (int j = pivotIndex + 1; j < len; j++) { // finding next smallest of pivot element
                    int d = inputStr[pivotIndex]-inputStr[j] ;
                    if (d < min && d > 0) {
                        replaceIndex = j;
                        min = d;
                    }
                }

                //Replacing pivot element with next highest element
                char temp = inputStr[pivotIndex];
                inputStr[pivotIndex] = inputStr[replaceIndex];
                inputStr[replaceIndex] = temp;
                //reversing
                for (i = 0; i <= pivotIndex; i++)
                    output += inputStr[i];
                for (i = len - 1; i > pivotIndex; i--)
                    output += inputStr[i];
                break;
            }
        }
        if (pivotIndex == -1)
            System.out.println("-1");
        else
            System.out.println(output);
    }
}
