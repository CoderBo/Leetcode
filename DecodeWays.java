package leetcode;


import java.util.Hashtable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * problem:A message containing letters from A-Z is
 * being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, 
 * determine the total number of ways to decode it.
 * @author chenbo
 */
public class DecodeWays 
{
    public static int numDecodings(String s) {
        if(s.length() == 0) return 0;
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        return numDecodings(s, table);
    }
    static int numDecodings(String s, Hashtable<String, Integer> table)
    {
        if(table.containsKey(s)) return table.get(s);
        if(!s.isEmpty() && s.charAt(0) == '0') return 0;
        if(s.length() <= 1) return 1;
        int firstTwo = Integer.parseInt(s.substring(0, 2));
        if(firstTwo > 26)
        {
            int result = numDecodings(s.substring(1), table);
            table.put(s, result);
            return result;
        }
        else
        {
            int result = numDecodings(s.substring(1), table) + numDecodings(s.substring(2), table);
            table.put(s, result);
            return result;
        }
    }
    
    public static int numDecodings3(String s)
    {
        if(s.length() == 0) return 1;
        if(s.length() == 1) return 1;
        int firstTwo = Integer.parseInt(s.substring(0, 2));
        //System.out.println(firstTwo);
        if(firstTwo > 26) return numDecodings3(s.substring(1));
        else return numDecodings3(s.substring(1)) + numDecodings3(s.substring(2));
    }
    public static void main(String[] args)
    {
        System.out.println(numDecodings3("1222"));
    }
}
