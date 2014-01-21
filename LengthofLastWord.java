/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a string s consists of upper/lower-case alphabets
 * and empty space characters ' ', return the length of last word 
 * in the string.
 * If the last word does not exist, return 0.
 * @author chenbo
 */
public class LengthofLastWord 
{
    static int lengthOfLastWord(String s)
    {
        StringBuilder a = new StringBuilder(s);
        a.reverse();
        int i = 0;
        for(i = 0; i < s.length(); i++)
        {
            if(a.charAt(i) != ' ') break;
        }
        if(i == s.length()) return 0;
        else
        {
            int result = 0;
            while(i < s.length() && a.charAt(i) != ' ')
            {
                result++;
                i++;
            }
            return result;
        }
    }
    public static void main(String[] args)
    {
        System.out.println(lengthOfLastWord("abc "));
    }
}
