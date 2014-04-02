/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given two numbers represented as strings, 
 * return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.


 * @author chenbo
 */
public class MultiplyStrings 
{
    static String multiply(String num1, String num2)
    {
        if(num1.isEmpty() || num2.isEmpty()) return null;
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] tempResult = new int[num1.length() + num2.length()];
        StringBuffer newNum1 = new StringBuffer(num1);
        num1 = newNum1.reverse().toString();
        StringBuffer newNum2 = new StringBuffer(num2);
        num2 = newNum2.reverse().toString();
        for(int i = 0; i < num1.length(); i++)
        {
            int digit1 = num1.charAt(i) - 48;
            for(int j = 0; j < num2.length(); j++)
            {
                int digit2 = num2.charAt(j) - 48;
                tempResult[i + j] += digit1 * digit2; 
                if(tempResult[i + j] >= 10)
                {
                    tempResult[i + j + 1] += tempResult[i + j] / 10;
                    tempResult[i + j] = tempResult[i + j] % 10;
                }
            }
        }
        StringBuffer result = new StringBuffer();
        for(int i : tempResult) result.append("" + i);
        result.reverse();
        String finalResult = result.toString();
        return finalResult.charAt(0) == '0'? finalResult.substring(1): finalResult;
    }
    
    
    static String multiply2(String num1, String num2) {
        if(num1.equals("0")) return num1;
        if(num2.equals("0")) return num2;
        int[] digits = new int[num1.length() + num2.length()];
        for(int i = num2.length() - 1; i >= 0; i--)
        {
            int start = num2.length() - i - 1;
            for(int j = num1.length()- 1; j >= 0; j--)
            {
                int m = num1.charAt(j) - 48;
                int n = num2.charAt(i) - 48;
                digits[start++] += m * n;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digits.length - 1; i++)
        {
            if(digits[i] >= 10)
            {
                digits[i + 1] += digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
            sb.append(digits[i]);
        }
        sb.append(digits[digits.length - 1]);
        sb.reverse();
        String result = sb.toString();
        return result.charAt(0) == '0'? result.substring(1) : result;
    }
    public static void main(String[] args)
    {
        System.out.println(multiply("9", "9"));
        System.out.println(multiply2("9", "9"));
    }
}
