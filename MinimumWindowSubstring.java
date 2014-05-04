/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Hashtable;

/**
 * problem:Given a string S and a string T, find the minimum window in 
 * S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * @author chenbo
 */
public class MinimumWindowSubstring 
{
    static String minWindow(String S, String T)
    {
        if(S.equals(T)) return S;
        Hashtable<Character, Integer> needToFind = new Hashtable<Character, Integer>();
        Hashtable<Character, Integer> hasFound = new Hashtable<Character, Integer>();
        for(int i = 0; i < T.length(); i++)
        {
            char c = T.charAt(i);
            if(needToFind.containsKey(c))
            {
                int temp = needToFind.get(c);
                needToFind.put(c, ++temp);
            }
            else needToFind.put(c, 1);
        }
        int minBegin = -1;
        int minEnd = 0;
        int count = 0;
        int begin = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        while(end < S.length())
        {
            char x = S.charAt(end);
            if(needToFind.containsKey(x))
            {
                if(!hasFound.containsKey(x)) hasFound.put(x, 1);
                else
                {
                    int temp = hasFound.get(x);
                    hasFound.put(x, temp + 1);
                }
                if(hasFound.get(x) <= needToFind.get(x)) count++;
            }
            end++;
            if(count == T.length())
            {
                if(result > end - begin + 1) 
                {
                    result = end - begin + 1;
                    minBegin = begin;
                    minEnd = end;
                }
                while(true)
                {
                    x = S.charAt(begin);
                    if(hasFound.containsKey(x))
                    {
                        if(hasFound.get(x) > needToFind.get(x))
                        {
                            int temp = hasFound.get(x);
                            hasFound.put(x, temp - 1);
                        }
                        else break;
                    }
                    begin++;
                    if(result > end - begin + 1) 
                    {
                        result = end - begin + 1;
                        minBegin = begin;
                        minEnd = end;
                    }
                }
            }
        }
        return minBegin == -1? "": S.substring(minBegin, minEnd);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    static String minWindow2(String S, String T)
    {
        if(S.equals(T)) return S;
        Hashtable<Character, Integer> needToFind = new Hashtable<Character, Integer>();
        Hashtable<Character, Integer> hasFound = new Hashtable<Character, Integer>();
        for(int i = 0; i < T.length(); i++)
        {
            char c = T.charAt(i);
            if(needToFind.containsKey(c))
            {
                int temp = needToFind.get(c);
                needToFind.put(c, temp + 1);
            }
            else needToFind.put(c, 1);
        }
        
        int min = Integer.MAX_VALUE;
        int minStart = -1;
        int start = 0;
        int count = 0;
        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            if(needToFind.containsKey(c))
            {
                if(!hasFound.containsKey(c)) hasFound.put(c, 1);
                else
                {
                    int temp = hasFound.get(c);
                    hasFound.put(c, temp + 1);
                }
                if(hasFound.get(c) <= needToFind.get(c)) count++;
                if(count == T.length())
                {
                    if(min > i - start + 1)
                    {
                        min = i - start + 1;
                        minStart = start;
                    }
                    while(true)
                    {
                        char d = S.charAt(start);
                        if(hasFound.containsKey(d))
                        {
                            if(hasFound.get(d) > needToFind.get(d))
                            {
                                int temp = hasFound.get(d);
                                hasFound.put(d, temp - 1);
                            }
                            else break;
                        }
                        start++;
                        if(min > i - start + 1)
                        {
                            min = i - start + 1;
                            minStart = start;
                            System.out.println(min);
                            System.out.println(S.substring(minStart, minStart + min)); 
                       }
                    }
                }
            }
        }
        return minStart == -1? "": S.substring(minStart, minStart + min);
    }
    public static void main(String[] args)
    {
        //System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow2("cabwefgewcwaefgcf", "cae"));
    }
}
