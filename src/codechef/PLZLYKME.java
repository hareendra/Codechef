package codechef;
import java.io.*;
/**
 * Created by reddy on 1/5/14.
 */
public class PLZLYKME {
    public static void main (String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//= new BufferedReader(new FileReader("in.txt"));
        int t=Integer.parseInt(in.readLine());

        for(int i=0;i<t;i++) {
            String str = in.readLine();
            String[] strAry=str.split(" ");

            int l=Integer.parseInt(strAry[0]);
            int d=Integer.parseInt(strAry[1]);
            int s=Integer.parseInt(strAry[2]);
            int c=Integer.parseInt(strAry[3]);

            /*int pow=power(c+1,d-1,l);
                for(int j=1;j<d;j++) {
                    s=(c+1)*s;
                    if (s>=l)
                        break;
            }*/

            if (amILikeable(c,d,l,s)) {
                System.out.println("ALIVE AND KICKING");
            }else {
                System.out.println("DEAD AND ROTTING");
            }
        }
    }

    static int power(int num, int pow,int likes) {
        if(pow==0)
            return 1;

        int hsqr=power(num,pow/2,likes);
        int sqr=hsqr*hsqr;

        if (pow%2==0) {
            if (sqr >=likes) {
                return -1;
            }
            return sqr;
        }else {
            if (hsqr*num >=likes) {
                return -1;
            }
            return sqr*num;
        }
    }

    static boolean amILikeable(double c,double d,double l,double s) {
        double lhs=(d-1)*Math.log(c+1)+Math.log(s);
        double rhs=Math.log(l);

        if (Math.abs(lhs-rhs) < 0.00000000001)
            return true;
        else if (lhs < rhs)
            return false;
        else
            return true;
    }
}