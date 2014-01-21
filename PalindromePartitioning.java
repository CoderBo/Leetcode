/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * problem:Given a string s, partition s such that every substring 
 * of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * or example, given s = "aab",
 * Return
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 * @author chenbo
 */
public class PalindromePartitioning 
{
    static boolean isPalindrome(String s)
    {
        StringBuilder builder = new StringBuilder(s);
        builder.reverse();
        return s.equals(builder.toString());
    }
    static ArrayList<ArrayList<String>> partition(String s, int start, Hashtable<Integer, ArrayList<ArrayList<String>>> table)
    {   
        if(table.containsKey(start)) return table.get(start);
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(start >= s.length())
        {
            ArrayList<String> sub = new ArrayList<String>();
            result.add(sub);
            return result;
        }   
        for(int i = start + 1; i <= s.length(); i++)
        {
            String head = s.substring(start,i);
            if(isPalindrome(head))
            {
                ArrayList<ArrayList<String>> sub = partition(s, i, table);
                for(ArrayList<String> a : sub)
                {
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add(head);
                    for(String n : a) temp.add(n);
                    result.add(temp);
                }
            }
        }
        table.put(start, result);
        return result;
    }
    static ArrayList<ArrayList<String>> partition(String s)
    {
        Hashtable<Integer, ArrayList<ArrayList<String>>> table = new Hashtable<Integer, ArrayList<ArrayList<String>>>();
        return partition(s, 0, table);
    }
    public static void main(String[] args)
    {
        System.out.println(partition("abba"));
    }
}
