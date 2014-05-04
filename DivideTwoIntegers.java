/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Divide two integers without 
 * using multiplication, division and mod operator.
 * @author chenbo
 */
public class DivideTwoIntegers 
{
    static int divide(int dividend, int divisor) 
    {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(dividend == divisor) return 1;
        if(divisor == 2) return dividend >> 1;
        if(dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE) return 0;
        int sign = 0;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sign = -1;
        else sign = 1;
        dividend = dividend == Integer.MIN_VALUE? Integer.MAX_VALUE : Math.abs(dividend);
        divisor = divisor == Integer.MIN_VALUE? Integer.MAX_VALUE : Math.abs(divisor);
        
        int result = (int)Math.floor(Math.pow(Math.E, Math.log(dividend) - Math.log(divisor)));
        return sign == -1? -result : result;
    }
    static int divide2(int dividend, int divisor) {
        int result = 0;
        int sign = 1;
        if(dividend < 0) sign = -sign;
        if(divisor < 0) sign = -sign;
        long a = dividend;
        long b = divisor;
        a = Math.abs(a);
        b = Math.abs(b);
        while(a >= b)
        {
            long temp = b;
            int multi = 1;
            while(a >= temp)
            {
                result += multi;
                a -= temp;
                temp += temp;
                multi += multi;
            }
        }
        return sign < 0 ? -result : result;
    }
    public static void main(String[] args)
    {
        System.out.println(divide(0, 2));
    }
}
