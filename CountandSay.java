/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...    
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * @author chenbo
 */
public class CountandSay 
{
    static String countAndSay(int n)
    {
        if(n == 1) return "1";
        String pre = countAndSay(n - 1);
        pre += "a";
        StringBuilder result = new StringBuilder();
        int count = 1;
        for(int i = 0; i < pre.length() - 1; i++)
        {
            if(pre.charAt(i + 1) != pre.charAt(i))
            {
                result.append(count);
                result.append(pre.charAt(i));
                count = 1;
            }
            else count++;
        }
        return result.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(countAndSay(5));
    }
}
