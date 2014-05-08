package InterviewStreet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HReddy on 5/8/2014.
 */
public class NonRepeatedCharacters {
    public static void main(String[] args)      {
        String str ="abcdadAA";
        HashMap<Character,Integer>  characterhashtable =firstNonRepeatedCharacter(str);

        // Search characterhashtable in in order of string str
        int i =0;
        for ( ; i < characterhashtable.size() ; i++ )    {
            char  c= str.charAt(i);
            if( characterhashtable.get(c)  == 1 ) {
                System.out.println(c);
                break;
            }
        }
        if(i==characterhashtable.size())
            System.out.println("Unique");

        //Find all the characters which are repeated more than 1 time and print them in lexicographical order.
        i=0;
        int count=0;
        ArrayList<Character> charAry=new ArrayList<Character>();
        for (Map.Entry<Character,Integer> entry:characterhashtable.entrySet() )    {
                if(entry.getValue()>1)
                    charAry.add(entry.getKey());
        }
        Collections.sort(charAry);
        System.out.println(charAry.toString());
    }

    public static HashMap<Character,Integer> firstNonRepeatedCharacter(String str)   {
        HashMap<Character,Integer>  characterhashtable=
                            new HashMap<Character ,Integer>();
        int i,length ;
        Character c ;
        length= str.length();  // Scan string and build hash table
        for (i=0;i < length;i++)   {
            c=str.charAt(i);
            if(characterhashtable.containsKey(c))    {
                // increment count corresponding to c
                characterhashtable.put( c , characterhashtable.get(c) +1 );
            }   else  {
                characterhashtable.put( c , 1 ) ;
            }
        }
        return characterhashtable;
    }
}
