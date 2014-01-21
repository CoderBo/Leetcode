/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author chenbo
 */
public class IntegertoRoman 
{
    static String intToRoman(int num)
    {
        StringBuilder result = new StringBuilder();
        while(num != 0)
        {
            if(num / 1000 != 0)
            {
                result.append("M");
                num -= 1000;
                continue;
            }
            if(num / 100 == 9)
            {
                result.append("CM");
                num -= 900;
                continue;
            }
            if(num / 100 >= 5)
            {
                result.append("D");
                num -= 500;
                continue;
            }
            if(num / 100 == 4)
            {
                result.append("CD");
                num -= 400;
                continue;
            }
            if(num / 100 != 0)
            {
                result.append("C");
                num -= 100;
                continue;
            }
            
            if(num / 10 == 9)
            {
                result.append("XC");
                num -= 90;
                continue;
            }
            if(num / 10 >= 5)
            {
                result.append("L");
                num -= 50;
                continue;
            }
            if(num / 10 == 4)
            {
                result.append("XL");
                num -= 40;
                continue;
            }
            if(num / 10 != 0)
            {
                result.append("X");
                num -= 10;
                continue;
            }
            
            if(num == 9)
            {
                result.append("IX");
                break;
            }
            if(num >= 5)
            {
                result.append("V");
                num -= 5;
                continue;
            }
            if(num == 4)
            {
                result.append("IV");
                break;
            }
            if(num != 0)
            {
                result.append("I");
                num -= 1;
                continue;
            }
        }
        return result.toString();
    }
    public static void main(String[] args)
    {
        System.out.println(intToRoman(1999));
    }
}
