/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * problem:Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * @author chenbo
 */
public class GenerateParentheses 
{
    static String insert(String s, int i)
    {
        String start = s.substring(0, i + 1);
        String end = s.substring(i + 1);
        return start + "()" + end;
    }
    static ArrayList<String> generateParenthesis(int n) 
    {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n == 0) return null;
        ArrayList<String> result = new ArrayList<String>();
        if(n == 1)
        {
            result.add("()");
            return result;
        }
        else
        {
            ArrayList<String> sub = generateParenthesis(n - 1);
            for(String s : sub)
            {
                for(int i = 0; i < s.length(); i++)
                {
                    if(s.charAt(i) == '(')
                    {
                        String newS = insert(s, i);
                        if(!result.contains(newS)) result.add(newS);
                    }     
                }
                if(!result.contains("()" + s)) result.add("()" + s);
            }
            Collections.sort(result);
            return result;
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(generateParenthesis(4));
    }
}
