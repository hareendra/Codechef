package InterviewStreet;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by HReddy on 5/8/2014.
 */
public class CoinChange {
    //Vector <Integer>a , int S
    static int minCoins (Vector <Integer> a ,int S)    {
        int lookup[] =new int[S+1];
        int biggestDenomAtSumK[] = new int[S+1];
        Arrays.fill(biggestDenomAtSumK,-1);

        for (int i=0; i<a.size(); i++) {
            for (int s=1; s<=S; s++)  {
                if (s >= a.get(i)) {
                    int minCoinsWithNewCoin = lookup[s-a.get(i)] + 1;
                    if (minCoinsWithNewCoin < lookup[s] || lookup[s]==0)
                    {
                        lookup[s] = minCoinsWithNewCoin;
                        biggestDenomAtSumK[s] = a.get(i);
                    }
                }
            }
        }

        return lookup[S];
    }

    public static void main(String[] args){
            Vector<Integer> v=new Vector<Integer>();

            v.add(5);
            System.out.printf("%d ", minCoins(v,11));
            return ;
    }
}
