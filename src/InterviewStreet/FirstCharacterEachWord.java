package InterviewStreet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class FirstCharacterEachWord {
    public static void main(String[] args)  {
        printFirstCharacterEachWord(" this  is a test case ");
    }

    private static void printFirstCharacterEachWord(String sentence) {
        String[] strAry=sentence.split("\\s+");

        for(String word:strAry) {
            if (word.length()>=1)
                System.out.print(word.charAt(0)+" ");
        }
    }
}
