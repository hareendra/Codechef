package codechef;

import java.io.*;
import java.util.*;

/**
 * Created by reddy on 1/5/14.
 */
public class PLZLYKME {
    public static  void main (String[] args) throws Exception
    {
        BufferedReader in   //= new BufferedReader(new InputStreamReader(System.in));
                = new BufferedReader(new FileReader("in.txt"));
        int t=Integer.parseInt(in.readLine());

        for(int i=0;i<t;i++)    {
            String str = in.readLine();
            String[] strAry=str.split(" ");

            int l=Integer.parseInt(strAry[0]);
            int d=Integer.parseInt(strAry[1]);
            int s=Integer.parseInt(strAry[2]);
            int c=Integer.parseInt(strAry[3]);


            for(int j=1;j<d;j++)    {
                  s=(c+1)*s;
                  if (s>=l)
                      break;
            }

            if (s>=l)    {
                System.out.println("ALIVE AND KICKING");
            }else   {
                System.out.println("DEAD AND ROTTING");
            }
        }
    }
}
