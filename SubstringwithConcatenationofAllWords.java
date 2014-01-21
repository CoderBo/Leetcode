/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.*;

/**
 * problem:You are given a string, S, and a list of words, L, 
 * that are all of the same length. Find all starting indices of 
 * substring(s) in S that is a concatenation of each word in L exactly 
 * once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * @author chenbo
 */
public class SubstringwithConcatenationofAllWords 
{
    static HashSet<String> generateSet(String[] L, int start)
    {
        HashSet<String> result = new HashSet<String>();
        if(L.length - start == 1)
        {
            result.add(L[start]);
            return result;
        }
        else
        {
            HashSet<String> sub = generateSet(L, start + 1);
            String word = L[start];
            for(String s : sub)
            {
                result.add(word + s);
                result.add(s + word);
                for(int i = 3; i < s.length(); i = i + 3)
                {
                    String head = s.substring(0, i);
                    String tail = s.substring(i);
                    result.add(head + word + tail);
                }
            }
        }
        return result;
    }
    static ArrayList<Integer> findSubstring2(String S, String[] L)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashSet<String> set = generateSet(L, 0);
        int length = L[0].length() * L.length;
        for(int i = 0; i < S.length() - length + 1; i++)
        {
            String word = S.substring(i, i + length);
            if(set.contains(word)) result.add(i);
        }
        return result;
    }
    
    static boolean check(String s, HashMap<String, Integer> map, int wordLength)
    {
        while(s.length() != 0)
        {
            String word = s.substring(0, wordLength);
            s = s.substring(wordLength);
            if(!map.containsKey(word)) return false;
            else
            {
                int temp = map.get(word);
                if(temp == 1) map.remove(word);
                else map.put(word, temp - 1);
            }
        }
        return map.isEmpty();
    }
    static ArrayList<Integer> findSubstring(String S, String[] L)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int length = L[0].length() * L.length;
        int wordLength = L[0].length();
        for(String s : L)
        {
            if(map.containsKey(s)) 
            {
                int temp = map.get(s);
                map.put(s, temp + 1);
            }
            else map.put(s, 1);
        }
        for(int i = 0; i < S.length() - length + 1; i++)
        {
            HashMap<String, Integer> map2 = (HashMap<String, Integer>) map.clone();
            for(int j = i; j < i + length; j += wordLength)
            {
                String word = S.substring(j, j + wordLength);
                if(!map2.containsKey(word)) break;
                else
                {
                    int temp = map2.get(word);
                    if(temp == 1) map2.remove(word);
                    else map2.put(word, temp - 1);
                }
            }
            if(map2.isEmpty()) result.add(i);
        }
        return result;
    }
    public static void main(String[] args)
    {
        String[] L = {"foo", "bar"};
        String s = "barfoothefoobarman";
        //System.out.println(generateSet(L, 0));
        System.out.println(findSubstring(s, L));
    }
}
