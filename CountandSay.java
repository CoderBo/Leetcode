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
        if(n <= 0) return null;
        if(n == 1) return "1";
        StringBuilder result = new StringBuilder();
        String previous = countAndSay(n - 1);
        previous += " ";
        int i = 1;
        int count = 1;
        char base = previous.charAt(0);
        while(i <= previous.length() - 1)
        {
            if(previous.charAt(i) == base)
            {
                count++;
                i++;
            }
            else
            {
                result.append(new Integer(count).toString());
                result.append(base);
                base = previous.charAt(i);
                count = 1;
                i++;
            }
        }
        return result.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(countAndSay(5));
    }
}
