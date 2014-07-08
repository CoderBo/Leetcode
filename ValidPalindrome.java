/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 * @author chenbo
 */
public class ValidPalindrome 
{
    static boolean isPalindrome(String s) 
    {
        if(s.length() == 1 || s.isEmpty()) return true;
        else 
        {
            String s1 = s.toLowerCase();
            StringBuilder s2 = new StringBuilder();
           
            for(int i = 0; i < s1.length(); i++)
            {
                if(s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z' || s1.charAt(i) >= '0' && s1.charAt(i) <= '9')
                {
                    s2.append(s1.charAt(i));
                }
            }
            return isPalindrome2(s2.toString());
        }
    }
    
    static boolean isPalindrome2(String s)
    {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j)
        {
            if(s.charAt(i) != s.charAt(j)) return false;
            else
            {
                i++;
                j--;
            }
        }
        return true;
    }
    
    public static boolean isPalindrome3(String s) {
        if(s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while(i < j)
        {
            char a, b;
            while(i < j && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) 
                i++;
            while(i < j && !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z' || s.charAt(j) >= 'A' && s.charAt(j) <= 'Z' || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) 
                j--;
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') a = (char) (s.charAt(i) + 32);
            else a = s.charAt(i);
            if(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') b = (char) (s.charAt(j) + 32);
            else b = s.charAt(j);
            if(a == b)
            {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        System.out.println(isPalindrome3("1a2"));
    }
}
