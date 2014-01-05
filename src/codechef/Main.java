package codechef;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: reddy
 * Date: 5/18/13
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static  void main (String[] args) throws Exception
    {
        BufferedReader in   //= new BufferedReader(new InputStreamReader(System.in));
                = new BufferedReader(new FileReader("in.txt"));
        int t=Integer.parseInt(in.readLine());
        for(int j=0;j<t;j++) {
            String str=in.readLine();
            if (str.contains("010")
                    || str.contains("101"))   {
                System.out.println("Good");
            }else {
                System.out.println("Bad");
            }
        }
    }
}
