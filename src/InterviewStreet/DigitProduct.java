package InterviewStreet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by reddy on 2/7/14.
 *
 Given an integer N, return an integer X, such that product of digits of X = N.
 If multiple values of X is possible, return the smallest possible. If there is no such X possible, return -1.
 Examples
 If N = 10, return 25.
 Note, the two possible values are 25 and 52. Return 25, since 25 is the smallest value.
 If N = 26, return -1
 There is no way to form a X for number 26. So return -1.
 If N = 100, return 455.
 Maximum value of N will be 10^6.
 */
public class DigitProduct {
    private static int[] factors={9,8,7,6,5,4,3,2};

    public  static void main(String[] args) {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        try     {
            int number=Integer.parseInt(in.readLine());
            if (number>=0&&number<=9){
                System.out.println(number);
            }else   {
                System.out.println(calcSmallestNum(number));
            }
        }catch  (IOException e) {
            e.printStackTrace();
        }
    }

    private static String calcSmallestNum(int number)   {
        String sub= "-1";

        if (number==1)
            return "";

        for(int factor:factors)    {
            if(number%factor==0)    {
                sub=calcSmallestNum(number/factor);

                if(sub!="-1")
                    return sub+factor;
            }
        }
        return sub;
    }
}
