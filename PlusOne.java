/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a number represented as an array of digits, 
 * plus one to the number.
 * @author chenbo
 */
public class PlusOne 
{   
    
    static boolean chechAllNine(int[] digits)
    {
        for(int i : digits)
        {
            if(i != 9) return false;
        }
        return true;
    }
    static int[] plusOne(int[] digits)
    {
        if(chechAllNine(digits) == true)
        {
            int[] newDigits = new int [digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        else
        {
            digits[digits.length - 1] += 1;
            for(int i = digits.length - 1; i > 0; i--)
            {
                if(digits[i] >= 10)
                {
                    digits[i] -= 10;
                    digits[i-1]++;
                }
                else break;
            }
            return digits;
        }
    }
    public static void main(String[] args)
    {
        int[] array = {0};
        int []array2 = plusOne(array);
        for(int i : array2)
        {
            System.out.println(i + " ");
        }
    }
}
