package CodeSprint5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

/**
 * Created by Kalyani on 1/17/14.
 */
public class SolutionGrid {

    static long mod = 1000000007;
    static long val;

    public static void  main(String[] args)
    {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine());

            long facts[] = new long[2000002];
            long inv[] = new long[2000002];
            facts[0] = 1;
            for (int i = 1; i <= 2000001; i++) {
                facts[i] = facts[i - 1] * i;

                facts[i]%=mod;
                val=facts[i];
                inv[i]=pow(mod-2);
            }

            for(int j=0;j<t;j++) {
                String[] strNumAry=in.readLine().split(" ");

                int n=Integer.parseInt(strNumAry[0]);
                int m=Integer.parseInt(strNumAry[1]);

                int tot=n+m-2;

                if ((n==1) || (m==1) ){
                    out.println("1");
                }else   {
                long res=(facts[tot]*inv[n-1])%mod;
                res=(res*inv[m-1])%mod;
                out.println(res);
                }
            }
            in.close();
            out.close();
        }catch (IOException i){

        }
    }
    private static long pow(long l) {
        if(l==0)return 1;
        if(l==1)return val;
        long ret=pow(l/2);
        ret*=ret;
        ret%=mod;
        if((l&1)==1)
        {
            ret*=val;
            ret%=mod;
        }
        return ret;
    }
}
