package CodeSprint5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

/**
 * Created by Kalyani on 1/17/14.
 */
public class SolutionGrid {
    public static void  main(String[] args)
    {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine());
            Map<BigInteger,BigInteger> factorials = new HashMap<BigInteger,BigInteger>();
            BigInteger mod = new BigInteger("1000000007");

            for(int i=0;i<t;i++) {
                String[] strNumAry=in.readLine().split(" ");

                int n=Integer.parseInt(strNumAry[0]);
                int m=Integer.parseInt(strNumAry[1]);

                int tot=n+m-2;

                BigInteger numerator = getFact(new BigInteger(String.valueOf(tot)),factorials);
                BigInteger denominator = new BigInteger("1");

                denominator = denominator.multiply(getFact(new BigInteger(String.valueOf(n-1)),factorials));
                denominator = denominator.multiply(getFact(new BigInteger(String.valueOf(m-1)),factorials));

                BigInteger answer = numerator.divide(denominator);
                out.println(answer.mod(mod));
            }
            in.close();
            out.close();
        }catch (IOException i){

        }
    }

    private static BigInteger getFact(BigInteger bigInteger,Map<BigInteger,BigInteger> factorials) {

        if(factorials.get(bigInteger) != null){
            return factorials.get(bigInteger);
        }else{
            BigInteger fact = fact(bigInteger);
            factorials.put(bigInteger,fact);
            return fact;
        }
    }

    private static BigInteger fact(BigInteger a) {
        if (a.compareTo(new BigInteger("0")) == 0)
            return new BigInteger("1");
        else if(a.compareTo(new BigInteger("1")) == 0)
            return a;
        else
            return a.multiply(fact(a.subtract(new BigInteger("1"))));
    }
}
