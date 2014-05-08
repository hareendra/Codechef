package InterviewStreet;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by HReddy on 5/8/2014.
 */
public class UniqueChars {
    public static void main(String[] args)  {
        System.out.println(checkUnique3("abcda"));
    }

    //Assuming ASCII characters
    public static boolean checkUnique(String str){
        boolean[] strSet = new boolean[256];//boolean array representing each character in char set
        for(int i = 0; i<str.length(); i++){
            int val = str.charAt(i);//we assign a character to an int so its ASCII value gets stored..!
            if(strSet[val]){ //if its already true
                return false; //we have a duplicate
            }
            strSet[val] = true; //set boolean value representing that character to be true
        }
        return true; // all characters in string was unique..!
    }

    //For any number of characters
    static boolean checkUnique2(String str){
        HashSet<Character> hashSet = new HashSet<Character>(str.length());
        for(char c : str.toCharArray()){ //iterate through character array
            if(!hashSet.add(Character.toUpperCase(c)))//try to add each char to hashset
                return false; //return false if could not add
        }
        return true;
    }

    //When the string is small
    static boolean checkUnique3(String str){
        char[] charAry=str.toCharArray();
        Arrays.sort(charAry);

        for(int i=0;i<charAry.length-1;i++){
            if(charAry[i]==charAry[i+1])
                return false;
        }
        return true;
    }
}
