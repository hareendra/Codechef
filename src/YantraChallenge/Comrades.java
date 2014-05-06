package YantraChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by HReddy on 5/6/2014.
 */
class Comrades {
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t=Integer.parseInt(in.readLine());

        for(int i=0;i<t;i++) {
            int n=Integer.parseInt(in.readLine());
            int[] soldierAry=new int[n+1];

            //Initialiazation
            soldierAry[0]=-1;
            String str = in.readLine();
            String[] strAry=str.split("\\s+");

            for(int j=0;j<strAry.length;j++){
                soldierAry[j+1]=Integer.parseInt(strAry[j]);
            }

            //System.out.println(Arrays.toString(soldierAry));
            int q= Integer.parseInt(in.readLine());

            for(int j=0;j<q;j++)    {
                str = in.readLine();
                strAry=str.split("\\s+");

                int x= Integer.parseInt(strAry[0]);
                int y= Integer.parseInt(strAry[1]);

                int count=0;

                while(soldierAry[x]!=-1){
                    x=soldierAry[x];
                    if(x==y)  {
                        break;
                    }
                    count++;
                }

                if(x==y){
                    out.println(count);
                }else   {
                    out.println(-1);
                }
            }
        }
        out.close();
    }
}
