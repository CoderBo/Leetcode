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
    static ArrayList<String> anagrams2(String[] strs) {
        Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
        for(String s : strs)
        {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if(array.length == 0) key = "";
            if(table.containsKey(key))
            {
                ArrayList<String> temp = table.get(key);
                temp.add(s);
                table.put(key, temp);
            }
            else 
            {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(s);
                table.put(key, temp);
            }
        }
        ArrayList<String> result = new ArrayList<String>();
        for(String key : table.keySet())
        {
            if(table.get(key).size() > 1) result.addAll(table.get(key));
        }
        return result;
    }
    public static void main(String[] args)
    {
        String[] array = {"",""};
        System.out.println(anagrams2(array));
    }
}