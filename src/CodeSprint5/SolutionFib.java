package CodeSprint5;


import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class SolutionFib {
    static class Fibonacci {
        private long [] fibAry ;
        int limit =50;
        public void calc_num() {
            fibAry=new long[limit];

            fibAry[0]=0;
            fibAry[1]=1;

            for(int i=2;i<limit;i++){
                fibAry[i]=fibAry[i-1]+fibAry[i-2];
            }
        }
        public String isFib(long num)   {
           if ( Arrays.binarySearch(fibAry,num) > 0)    {
               return "IsFibo";
           }else {
               return "IsNotFibo";
           }
        }
    }
    public static void main (String[] args) throws Exception
    {
        Fibonacci f=new Fibonacci();
        f.calc_num();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());

        for(int i=0;i<t;i++) {
                long n=Long.parseLong(in.readLine());
                out.println(f.isFib(n));
        }
        in.close();
        out.close();
    }
}
