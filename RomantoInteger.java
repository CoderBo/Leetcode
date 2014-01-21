/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Hashtable;

/**
 * problem:Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author chenbo
 */
public class RomantoInteger 
{
    static int romanToInt(String s)
    {
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        table.put('I', 1);
        table.put('V', 5);
        table.put('X', 10);
        table.put('L', 50);
        table.put('C', 100);
        table.put('D', 500);
        table.put('M', 1000);
        int result = 0;
        for(int i =0; i < s.length() - 1; i++)
        {
            int current = table.get(s.charAt(i));
            int next = table.get(s.charAt(i + 1));
            current *= current >= next? 1 : -1;
            result += current;
        }
        result += table.get(s.charAt(s.length() - 1));
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(romanToInt("MMDCCCLVI"));
    }
}
