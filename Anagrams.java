/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;
import java.util.*;
/**
 * problem:Given an array of strings, return all groups of strings that are anagrams.
 * @author chenbo
 */
public class Anagrams 
{
    static String sortString(String str)
    {
        char[] word = str.toCharArray();
        Arrays.sort(word);
        return new String(word);
    }
    static ArrayList<String> anagrams(String[] strs) 
    {
        ArrayList<String> result = new ArrayList<String>();
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        String[] newStr = new String[strs.length];
        ArrayList<Integer> index = new ArrayList<Integer>();
        for(int i = 0; i < strs.length; i++)
        {
            newStr[i] = sortString(strs[i]);
            if(!table.containsKey(newStr[i])) table.put(newStr[i], i);
            else
            {
                if(!result.contains(strs[table.get(newStr[i])])) result.add(strs[table.get(newStr[i])]);
                result.add(strs[i]);
            }
        }
        return result;    
    }
    
    public static void main(String[] args)
    {
        String[] array = {"123","321","333","213"};
        System.out.println(anagrams(array));
    }
}