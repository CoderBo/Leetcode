/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.*;

/**
 * problem:Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated 
 * sequence of one or more dictionary words.
 * @author chenbo
 */
public class WordBreak 
{
    static boolean wordBreak(String s, Set<String> dict)
    {
        Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
        return wordBreak2(s, dict, table);
    }
    static boolean wordBreak2(String s, Set<String> dict, Hashtable<String, Boolean> table) 
    {
        if(dict.contains(s)) return true;
        if(table.containsKey(s)) return table.get(s);
        for(int i = 1; i < s.length(); i++)
        {
            String prefix = s.substring(0,i);
            if(dict.contains(prefix))
            {
                String suffix = s.substring(i, s.length());
                if(wordBreak2(suffix, dict, table)) 
                {
                    table.put(suffix, true);
                    return true;
                }
            }
        }
        table.put(s, false);
        return false;
    }
    public static void main(String[] args)
    {
        String s ="aaaaaaa";
        Set<String> dict = new HashSet<String>();
        dict.add("aaaa");
        dict.add("aaa");
        dict.add("apple");
        dict.add("peach");
        
       
        System.out.println(wordBreak(s, dict));
    }
}
