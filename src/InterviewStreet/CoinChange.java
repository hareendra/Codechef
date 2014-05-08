package InterviewStreet;

import java.util.Arrays;

/**
 * Created by HReddy on 5/8/2014.
 */
public class CoinChange {
    static int findMinCoins (int sum, int denoms[])    {
        int lookup[] =new int[sum+1];
        int biggestDenomAtSumK[] = new int[sum+1];
        Arrays.fill(biggestDenomAtSumK,-1);

        for (int i=0; i<denoms.length; i++) {
            for (int s=1; s<=sum; s++)  {
                if (s >= denoms[i]) {
                    int minCoinsWithNewCoin = lookup[s-denoms[i]] + 1;
                    if (minCoinsWithNewCoin < lookup[s] || lookup[s]==0)
                    {
                        lookup[s] = minCoinsWithNewCoin;
                        biggestDenomAtSumK[s] = denoms[i];
                    }
                }
            }
        }
        /*
        int S=sum;
        while (S > 0)   {
            System.out.println (biggestDenomAtSumK[S]);
            S = S - biggestDenomAtSumK[S];
        }*/

        return lookup[sum];
    }

    public static void main(String[] args){
            int denom[] = {2,3};
            System.out.printf("%d ", findMinCoins(1,denom));
            return ;
    }
}
