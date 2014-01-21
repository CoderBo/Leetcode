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
    static Hashtable<String, Integer> table = new Hashtable<String, Integer>();
    static int numDecodings(String s)
    {
        if(s == null || s.length() == 0) return 0;
        else return numDecodings2(s);
    }
    
    static int numDecodings2(String s)
    {
        if(table.containsKey(s)) return table.get(s);
        if(s == null || s.length() == 0) return 1;
        if(s.equals("0")) return 0;
        if(s.length() == 1) return 1;
        if(Integer.parseInt(Character.toString(s.charAt(0))) == 0) return 0 * numDecodings2(s.substring(1));
        int firstTwo = Integer.parseInt(Character.toString(s.charAt(0)) + Character.toString(s.charAt(1)));
        if(firstTwo > 26)
        {
            int result = numDecodings2(s.substring(1));
            table.put(s, result);
            return result;
        }
        else
        {
            int result = numDecodings2(s.substring(1)) + numDecodings2(s.substring(2));
            table.put(s, result);
            return result;
        }
    }
    public static void main(String[] args)
    {
        System.out.println(numDecodings("1222"));
    }
}
