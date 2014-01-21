/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * problem:Implement wildcard pattern matching with support for '?' and '*'
 * '?' Matches any single character.'*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * @author chenbo
 */
public class WildcardMatching2 
{
    static boolean match(String a, String b)
    {
       // System.out.println(a + ' ' + b);
        for(int i = 0; i < a.length(); i++)
        {
            if(b.charAt(i) != '?' && a.charAt(i) != b.charAt(i))
            {
                return false;
            }
                
        }
        return true;
    }
    static ArrayList<String> cut(String p)
    {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < p.length(); i++)
        {
            if(p.charAt(i) == '*')
            {
                if(s.length() > 0) 
                {
                    result.add(s.toString());
                    s = new StringBuilder();   
                }
            }
            else s.append(p.charAt(i));
        }
        ArrayList<String> result2 = new ArrayList<String>();
        result.add(s.toString());
        for(String i : result)
        {
            if(i.length() != 0) result2.add(i);
        }
        return result2;
    }
    static boolean isMatch(String s, String p)            
    {  
        if(s.equals(p)) return true;
        if(p.equals("*")) return true;
        if(p.length() == 0 || s.length() == 0) return false;
        ArrayList<String> array = cut(p);
        ArrayList<String> copy = cut(p);
 
        if(array.size() == 0) return true;
        if(array.size() == 1 && p.charAt(0) != '*' && p.charAt(p.length() - 1) != '*')
        {
            if(s.length() != p.length()) return false;
            return match(s, p);
        }
        int amount = 0;
        for(String i : array)
        {
            amount += i.length();
        }
        if(s.length() < amount) return false;
        if(p.charAt(0) != '*') 
        {
            if(!match(s.substring(0,array.get(0).length()), array.get(0)))
            {
                return false;
            }
                
        }
        if(p.charAt(p.length() - 1) != '*') 
        {
           // System.out.println(s.substring(s.length() - array.get(array.size() - 1).length()));
           // System.out.println(array.get(array.size() - 1));
            if(!match(s.substring(s.length() - array.get(array.size() - 1).length()), array.get(array.size() - 1)))
                return false;
        }
        int index = 0;
        for(int i = 0; i < s.length();)
        {
            if(i + copy.get(index).length() > s.length()) 
            {
                return false;
            }
            String sub = s.substring(i, i + copy.get(index).length());
            if(match(sub, copy.get(index)))
            {
                i = i + copy.get(index).length();
                
                array.remove(0);
                if(array.isEmpty()) return true;
                index++;        
            }
            else i++;
        }
        return false;
    }
    public static void main(String[] args)
    {
        System.out.println(isMatch("aba","a*a"));
        System.out.println(isMatch("abce","abc*?"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", "?*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a********b"));
        System.out.println(isMatch("aabbbaabbabbbabbabbbaaabaaababbababaabbababaaaaabbaababbabaabbbaaabaaaabbbabaaabbabaaaaaaaababbaaaaabbbaabbabbaabbbbabbababbbabbbababbababaabaaabbababbababbbbaabaaababbbbbababbbbaaaaaaabbbabbbbbbabbaba", "**a*abbbb*a*ba****ba**a**a*ba**a****aaa**abaa****aa**aaaa*bbbbbaaa*bb**aaabaaaa*aab*ab*aaabbb*b**a*aa*a"));
        System.out.println(isMatch("aab", "??*b"));
    }
}
