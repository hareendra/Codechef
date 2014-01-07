package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by reddy on 1/7/14.
 */
public class FGFS {
    public static void main (String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//= new BufferedReader(new FileReader("in.txt"));
        int t=Integer.parseInt(in.readLine());

        for(int i=0;i<t;i++) {
            int n=Integer.parseInt(in.readLine());
            int[] ary=new int[n];

            String[] strAry= in.readLine().split(" ");
            for(int j=0;j<n;j++) {
                ary[j]=Integer.parseInt(strAry[j]);
            }

            strAry= in.readLine().split(" ");

            int a=Integer.parseInt(strAry[0]);
            int b=Integer.parseInt(strAry[1]);
            int c=Integer.parseInt(strAry[2]);

            String s=in.readLine();

            for(int j=0;j<s.length();j++) {
                if(s.charAt(j) == 'R')
                    rev(ary,j,n);
                else if (s.charAt(j) == 'A')
                    add(ary,j,n,a,c);
                else if (s.charAt(j) == 'M')
                    mul(ary, j, n, b, c);
            }

            for(int num:ary) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    static void rev(int[] ary,int i,int len) {
        int temp=0;
        while(i<len) {
            temp=ary[i];
            ary[i]=ary[len-i];
            ary[len-i]=temp;
            i++;
        }
    }

    static void add(int[] ary,int start,int len, int addNum,int modulo) {
        for(int i=start;i<len;i++) {
            ary[i]=(ary[i]+addNum)%modulo;
        }
    }
    static void mul(int[] ary,int start,int len, int mulNum,int modulo) {
        for(int i=start;i<len;i++) {
            ary[i]=(ary[i]*mulNum)%modulo;
        }
    }
}