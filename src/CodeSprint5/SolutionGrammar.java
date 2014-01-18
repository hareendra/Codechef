package CodeSprint5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Kalyani on 1/18/14.
 */
public class SolutionGrammar {
    public static void  main(String[] args)
    {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(System.out);

            String str=in.readLine();

            int t=Integer.parseInt(in.readLine());

            for(int i=0;i<t;i++)    {
                in.readLine();
                out.println("place");
            }
            in.close();
            out.close();
        }catch(IOException i)   {

        }
    }
}
