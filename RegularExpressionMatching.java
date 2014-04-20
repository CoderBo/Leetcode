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
    public static boolean isMatch(String s, String p)
    {
        Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
        return isMatch(s, p, table);
    }
    public static boolean isMatch(String s, String p, Hashtable<String, Boolean> table) {
        if(table.containsKey(s + " " + p)) return table.get(s + " " + p); 
        if(s.equals(p)) return true;
        if(p.length() == 0) return s.length() == 0;
        if(p.length() == 1)
        {
            if(p.charAt(0) == '.') return s.length() == 1;
            else return false;
        }
        if(p.charAt(1) != '*')
        {
            if(s.length() == 0) return false;
            if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                return isMatch(s.substring(1), p.substring(1), table);
            else return false;
        }
        else
        {
            String base = "";
            String item = p.substring(0, 1);
            p = p.substring(2);
            for(int i = 0; i < s.length() + 1; i++)
            {
                if(isMatch(s, base + p, table)) return true;
                base += item;
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
        System.out.println(isMatch("baccbbcbcacacbbc","a*a*a*a*a*a*a*a*a*a*c"));
        System.out.println(isMatch("bbbc","b*c*"));
    }
}
