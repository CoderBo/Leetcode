/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Reverse digits of an integer.
 * @author chenbo
 */
public class ReverseInteger 
{
    static int reverse(int x)
    {
         boolean negative = x < 0 ? true : false;
        if(x < 0) x = -x;
        int result = 0;
        while(x > 0)
        {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return negative? -result : result;
    }
    public static void main(String[] args)
    {
        System.out.println(reverse(-100));
    }
}
