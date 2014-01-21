/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

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
public class WildcardMatching 
{
    static String deletStar(String s)
    {
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++)
        {
            if(s.charAt(i) != '*' || s.charAt(i - 1) != '*') 
                result.append(s.charAt(i));
        }
        return result.toString();
    }
    
    static boolean isMatch(String s, String p)
    {
        int count = 0;
        for(char c : p.toCharArray())
        {
            if(c != '*') count++;
            if(count > s.length()) return false;
        }
        return isMatch2(s, p, new Hashtable<String, Boolean>());
    }
    static boolean isMatch2(String s, String p, Hashtable<String, Boolean> table)
    {
        if(table.containsKey(s + " " + p)) return table.get(s + " " + p);
        if(s.equals(p)) return true;
        if(p.equals("*")) return true;
        if(p.length() == 0 || s.length() == 0) return false;
        if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') 
            return isMatch2(s.substring(1), p.substring(1), table);
        p = deletStar(p);
        if(p.charAt(0) == '*')
        {
            String newP = p.substring(1);
            for(int i = 0; i < s.length(); i++)
            {
                if(isMatch2(s.substring(i), newP, table)) 
                {
                    table.put(s + " " + p, true);
                    return true;
                }
            }
            table.put(s + " " + p, false);
            return false;
        }
        table.put(s + " " + p, false);
        return false;
    }
    public static void main(String[] args)
    {
      /*  System.out.println(isMatch("a","aa"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", "?*"));*/
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a********b"));
        System.out.println(isMatch("aabbbaabbabbbabbabbbaaabaaababbababaabbababaaaaabbaababbabaabbbaaabaaaabbbabaaabbabaaaaaaaababbaaaaabbbaabbabbaabbbbabbababbbabbbababbababaabaaabbababbababbbbaabaaababbbbbababbbbaaaaaaabbbabbbbbbabbaba", "**a*abbbb*a*ba****ba**a**a*ba**a****aaa**abaa****aa**aaaa*bbbbbaaa*bb**aaabaaaa*aab*ab*aaabbb*b**a*aa*a"));
        System.out.println(isMatch("aab", ""));
    }
}
