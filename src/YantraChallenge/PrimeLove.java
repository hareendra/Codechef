package YantraChallenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
/**
 * Created by HReddy on 5/6/2014.
 */
class PrimeLove {

    public static void main(String[] args)  throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        //int[] primeAry = generatePrimes(10000);
        //HashMap<Integer,Integer> hashPrime= generateHash(primeAry);

        int tc=Integer.parseInt(in.readLine());

        for (int i=0;i<tc;i++)  {
            int num = Integer.parseInt(in.readLine());
            if (num ==2)
                out.println("Arjit");
            else
                out.println("Deepa");
            /*if(checkForSumOfPrimes(i, primeAry, hashPrime,out)){
               // out.println("Deepa");
            }else {
               // out.println("Arijit");
            }*/
        }
        out.close();
    }
    private static boolean checkForSumOfPrimes (int num ,int[] primeAry,HashMap<Integer,Integer> hashPrime ,PrintWriter out){
        for(int i=0;i<primeAry.length;i++){
            Integer diffNum = hashPrime.get(num-primeAry[i]);
            if (diffNum != null)  {
                out.println(num+ " "+ primeAry[i]+" "+ (num-primeAry[i]) + " Deepa"  );
                return true;
            }
            if (num < primeAry [i] ){
                out.println(num+ " Arijit"  );
                return false;
            }
        }
        out.println(num+ " Arijit"  );
        return false;
    }

    private static int [] generatePrimes(int max) {
        int [] temp = new int [max];
        temp [0] = 2;
        int index = 1;
        int prime = 1;
        boolean isPrime = false;
        while((prime += 2) <= max) {
            isPrime = true;
            for(int i = 0; i < index; i++) {
                if(prime % temp [i] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                temp [index++] = prime;
            }
        }
        int [] primes = new int [index];
        while(--index >= 0) {
            primes [index] = temp [index];
        }
        return primes;
    }

    private static HashMap<Integer,Integer> generateHash(int[] primeAry)  {
        HashMap<Integer,Integer> primeMap =new HashMap<Integer,Integer>();

        for(int num:primeAry)   {
            primeMap.put(num,num);
        }
        return primeMap;
    }
}
