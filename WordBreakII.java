/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.*;

/**
 * problem:Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * @author chenbo
 */
public class WordBreakII
{
    static ArrayList<String> wordBreak(String s, Set<String> dict)
    {
        Map<String, ArrayList<String>> table = new HashMap<String, ArrayList<String>>();
        return wordBreak2(s, dict, table);
    }
    static ArrayList<String> wordBreak2(String s, Set<String> dict, Map<String, ArrayList<String>> table)
    {
        if(table.containsKey(s)) return table.get(s);
        ArrayList<String> result = new ArrayList<String>();
        if(dict.contains(s))
        {
           result.add(s);
        }
        for(int i = 0; i < s.length(); i++)
        {
            String prefix = s.substring(0, i);
            if(dict.contains(prefix))
            {
                String suffix = s.substring(i, s.length());
                ArrayList<String> sub = wordBreak2(suffix, dict, table);
                for(String x : sub)
                {
                    result.add(prefix + " " + x);
                }
            }        
        }
        table.put(s, result);
        return result;      
    }
    
    public static void main(String[] args)
    {
        String s = "catsanddog";
        String s3 = "aaaaaaa";
        String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Set set = new HashSet();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
     //   set.add("aaaaaaaaaa");
     //   set.add("aaaaaaaaa");
     //   set.add("aaaaaaaa");
     //   set.add("aaaaaaa");
     //   set.add("aaaaaa");
     //   set.add("aaaaa");
        set.add("aaaa");
     //   set.add("aaa");
        set.add("aa");
        set.add("a");
     //   set.add("aaaa");
     //   set.add("aaa");
        System.out.println(wordBreak(s3, set));     
    }
}
