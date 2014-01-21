/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;


/**
 * problem:Given two strings s1 and s2 of the same length, 
 * determine if s2 is a scrambled string of s1.
 * @author chenbo
 */
public class ScrambleString 
{
    static boolean isScramble(String s1, String s2)
    {
        if(s1.length() != s2.length()) return false;
        if(s1.equals(s2)) return true;
        int length = s1.length();
        int[] array = new int[256];
        for(int i = 0; i < length; i++) array[s1.charAt(i)]++;
        for(int i = 0; i < length; i++) array[s2.charAt(i)]--;
        for(int i : array) if(i != 0) return false;
        
        for(int i = 1; i < length; i++)
        {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);
            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
            s21 = s2.substring(length - i);
            s22 = s2.substring(0, length - i);
            if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        System.out.println('a');
        String s = "great";

        System.out.println(isScramble("abcd", "edab"));
    }
}
