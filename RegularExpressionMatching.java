/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Hashtable;

/**
 * problem:
 * @author chenbo
 */
public class RegularExpressionMatching 
{
    static boolean isMatch(String s, String p)
    {
        return isMatch2(s, p, new Hashtable<String, Boolean>());
    }
    
    static boolean check(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != '.') return false;
        }
        return true;
    }
    
    static boolean isMatch2(String s, String p, Hashtable<String, Boolean> table)
    {
        if(table.containsKey(s + " " + p)) return table.get(s + " " + p);
        if(s.equals(p)) return true;
        if(s.length() == p.length() && check(p)) return true;
        if(p.length() == 0) return false;
        if(p.length() == 1) return p.equals(".") && s.length() == p.length();
        if(p.charAt(1) != '*')
        {
            if(s.length() == 0) return false;
            if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
            {
                String newS = s.substring(1);
                String newP = p.substring(1);
                return isMatch2(newS, newP, table);
            }
            else return false;
        }
        else
        {
            if(s.length() == 0 && p.charAt(p.length() - 1) != '*') return false;
            if(isMatch2(s, p.substring(2), table)) return true;
            if(isMatch2(s, p.charAt(0) + p.substring(2), table)) return true;
            for(int i = 0; i < s.length() - 1; i++)
            {
                StringBuilder duplicate = new StringBuilder();
                for(int j = 0 ; j <= i; j++)
                {
                    duplicate.append(p.charAt(0));
                }
                String newP = p.charAt(0) + duplicate.toString() + p.substring(2);
                if(isMatch2(s, newP, table)) return true;
            }
            table.put(s + " " + p, false);
            return false;
        }
    }
    public static void main(String[] args)
    {
      //  System.out.println(isMatch("aa","a"));
      //  System.out.println(isMatch("aa","aa"));
      //  System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("aa","*"));
        System.out.println(isMatch("aa",".*"));
        System.out.println(isMatch("ab",".*"));
        System.out.println(isMatch("aab","c*a*b"));
        System.out.println(isMatch("aaaaaaaaaaaaab","a*a*a*a*a*a*a*a*a*a*c"));
        System.out.println(isMatch("bbbc","b*c*"));
    }
}
