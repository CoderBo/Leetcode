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
        boolean negetive = false;
        String s = Integer.toString(x);
        StringBuilder s2 = new StringBuilder(s);
        if(s2.charAt(0) == '-')
        {
            negetive = true;
            s2.deleteCharAt(0);
        }
        s2.reverse();
        int result = Integer.parseInt(s2.toString());
        return negetive == true ? result * -1 : result;
    }
    public static void main(String[] args)
    {
        System.out.println(reverse(-100));
    }
}
