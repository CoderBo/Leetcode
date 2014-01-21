/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Arrays;

/**
 * problem:Given two binary strings, return their sum (also a binary string).
 * @author chenbo
 */
public class AddBinary 
{
    static int [] stringToInt(String s)
    {
        int[] array = new int[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '1') array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }
    public static String addBinary(String a, String b)
    {
        StringBuilder x = new StringBuilder();
        StringBuilder y = new StringBuilder();
        StringBuilder i = new StringBuilder(a);
        StringBuilder j = new StringBuilder(b);
        if(a.length() > b.length())
        {
            x = i.reverse();
            y = j.reverse();
        }
        else
        {
            y = i.reverse();
            x = j.reverse();
        } 
        int[] ai = stringToInt(x.append("0").toString());
        int[] bj = stringToInt(y.toString());
        int indexA = 0;
        int indexB = 0;
        while(indexB < bj.length)
        {
            ai[indexA] += bj[indexB];
            if(ai[indexA] >= 2) 
            {
                ai[indexA] -= 2;
                ai[indexA + 1]++;
            }
            indexA++;
            indexB++;
        }
        while(indexA < ai.length)
        {
            if(ai[indexA] >= 2) 
            {
                ai[indexA] -= 2;
                ai[indexA + 1]++;
            }
            indexA++;
        }
        StringBuilder result = new StringBuilder();
        for(int m = 0; m < ai.length; m++)
        {
            result.append(ai[m]);
        }
        String result2 = result.reverse().toString();
        if(result2.charAt(0) == '0') return result2.substring(1);
        else return result2;
    }
    public static void main(String[] args)
    {
        
        System.out.println(addBinary("1", "111"));
    }
}
