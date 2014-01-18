package CodeSprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kalyani on 1/18/14.
 */
public class SolutionNine {

    static ArrayList<Long> listNum=new ArrayList<Long>();
    static int limit=4200;
    static HashMap<Integer,Long> listMap =new HashMap<Integer, Long>();
    static int numLimit=500;

    public static void  main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);

            Integer nine=new Integer("9");

            for(int i=1;i<limit;i++)  {
                    listNum.add(Long.valueOf(Integer.toBinaryString(i)) * 9);
            }

            for(int i=1;i<=numLimit;i++)    {
                for(Long num:listNum)    {
                    if (num % i == 0)   {
                        listMap.put(i,num);
                        break;
                    }
                }
            }

           /* for (Map.Entry<Integer,Long> entry : listMap.entrySet()) {
                Integer key = entry.getKey();
                Long value = entry.getValue();
                out.println(key+" "+value);
            }*/

            int t=Integer.parseInt(in.readLine());

            for(int j=0;j<t;j++) {
                int n=Integer.parseInt(in.readLine());
                out.println(listMap.get(n).longValue());
            }

            in.close();
            out.close();
        }catch(IOException i)   {

        }
    }

}
