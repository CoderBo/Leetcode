/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Determine whether an integer is a palindrome. Do this without extra space.
 * @author chenbo
 */
public class PalindromeNumber 
{
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int div = 1, head = 0, tail = 0;
        while(x / div >= 10)
        {
            div *= 10;
        }
        while(x >= 10)
        {
            head = x / div;
            tail = x % 10;
            if(head != tail) return false;
            else
            {
                x = x - head * div;
                x /= 10;
                div /= 100;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        System.out.println(isPalindrome(1000110001));
       // System.out.println(inverse(86));
    }
   
}
