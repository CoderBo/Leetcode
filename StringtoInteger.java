/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Implement atoi to convert a string to an integer.
 * @author chenbo
 */
public class StringtoInteger 
{
    static int atoi(String str)
    {
        if(str.length() == 0 || str == null) return 0;
        StringBuilder result1 = new StringBuilder();
        int signNegetive = 0;
        int signPositive = 0;
        boolean sign2 = false;
        for(int i = 0; i < str.length(); i++)
        {
            if(result1.length() == 0 && str.charAt(i) == 32 && sign2 == false) continue;
            if(str.charAt(i) >= 48 && str.charAt(i) <= 57)
            {
                result1.append(str.charAt(i));
            }
            else if(str.charAt(i) == '-')
            {
                signNegetive++;
                sign2 = true;
            }
            else if(str.charAt(i) == '+') 
            {
                signPositive++;
                sign2 = true;
                continue;
            }
            else if(result1.length() == 0) return 0;
            else break;       
        }
        if(signNegetive >= 2 || signPositive >= 2) return 0;
        if(result1.length() == 0) return 0;
        if(result1.length() >= 11) return signNegetive != 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
        int result2 = 0;
        if(signNegetive == 0 && result1.toString().equals("2147483648")) return Integer.MAX_VALUE;
        if(signNegetive == 1 && result1.toString().equals("2147483648")) return Integer.MIN_VALUE;
        if(result1.length() == 10)
        {
            char rest2 = result1.charAt(result1.length() - 1);
            int rest = Character.getNumericValue(rest2);
            result1.deleteCharAt(result1.length() - 1);
            result2 = Integer.parseInt(result1.toString());
            if(Integer.MAX_VALUE / 10 >= result2) result2 *= 10;
            else return signNegetive != 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            if(result2 <= Integer.MAX_VALUE - rest) result2 += rest;
            else return signNegetive != 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        else
        {
            result2 = Integer.parseInt(result1.toString());
        }
        return signNegetive == 1? result2 * -1: result2;
    }
    
    static int atoi2(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        boolean positive = true;
        int i = 0;
        if(str.charAt(0) == '-') 
        {
            positive = false;
            i++;
        }
        else if(str.charAt(0) == '+')
        {
            positive = true;
            i++;
        }
        double result = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9')
        {
            result = result * 10 + (int)(str.charAt(i) - '0');
            i++;
        }
        if(positive == false) result = -result;
        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;
    }
    public static void main(String[] args)
    {
        System.out.println(atoi("      -11919730356x"));
    }
}
