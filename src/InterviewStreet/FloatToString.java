package InterviewStreet;

/**
 * Created by HReddy on 5/9/2014.
 */
public class FloatToString {
    public static void main(String[] args){
        float f=3f;

        printFloatString(f);
        System.out.println(f);
    }
    private static void printFloatString(float f){
        int i, j = 0;
        i = (int) f;

        f = f - i;
        int count=0;
        while(count<6) {
            f *= 10;
            j = (j*10) + (int) f;
            f = f - (int) f;
            count++;
        }

        //Trim additional zeros
        while(j>0&&j%10==0)  {
            j=j/10;
        }

        System.out.println(Integer.toString(i) + "." + Integer.toString(j));
    }
}
