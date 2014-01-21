/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Queue;
import java.util.Stack;

/**
 * problem: Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
   brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author chenbo
 */
public class ValidParentheses 
{
    static  boolean isValid(String s)
    {
        if(s.length() % 2 != 0) return false;
        if(s.length() == 0) return true;
        Stack<Character> st = new Stack<Character>();
        int i = 0;
        while(i < s.length())
        {
            switch(s.charAt(i))
            {
                case '(':
                    st.push('(');
                    break;
                case ')':
                    if(!st.isEmpty() && st.pop() == '(') break;
                    else return false;
                case '[':
                    st.push('[');
                    break;
                case ']':
                    if(!st.isEmpty() && st.pop() == '[') break;
                    else return false;
                case '{':
                     st.push('{');
                    break;
                case '}':
                    if(!st.isEmpty() && st.pop() == '{') break;
                    else return false;
            }
            i++;
        }
        return st.isEmpty();
    }
    public static void main(String[] args)
    {
        System.out.println(isValid("{[]}()"));
    }
}
