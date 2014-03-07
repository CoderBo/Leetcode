/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * problem:Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * @author chenbo
 */
public class ReverseWordsinaString 
{
    static String reverseWords(String s)
    {
        if(s.length() == 0) return s;
        s += " ";
        StringBuilder temp = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == ' ') 
            {
                if(temp.length() > 0) stack.push(temp.toString());
                temp = new StringBuilder();
            }
            else temp.append(c);
        }
        if(stack.isEmpty()) return "";
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
        {
            result.append(stack.pop());
            if(!stack.isEmpty()) result.append(" ");
        }
        return result.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(reverseWords("         "));
    }
}
