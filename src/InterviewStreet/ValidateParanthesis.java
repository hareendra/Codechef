package InterviewStreet;

import java.util.Stack;

/**
 * Created by HReddy on 5/8/2014.
 */
public class ValidateParanthesis {
    public static boolean isParenthesisMatch(String str) {
        if (str.charAt(0) == '{')
            return false;

        Stack<Character> stack = new Stack<Character>();

        char c;
        for(int i=0; i < str.length(); i++) {
            c = str.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')')
                if(stack.empty())
                    return false;
                else if(stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            else    {   //Read any other character
                //Do nothing
            }
        }
        return stack.empty();
    }

    public static void main(String[] args){
        System.out.println(isParenthesisMatch("(a())"));
    }
}
