/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:
 * @author chenbo
 */
public class ZigZagConversion 
{
    static String convert(String s, int nRows) {
        if(s.length() == 0 || nRows <= 1 || s.length() <= nRows) return s;
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < nRows; i++) list.add("");
        int index = 0;
        boolean goDown = true;
        for(int i = 0; i < s.length(); i++)
        {
            String temp = list.get(index);
            temp += s.charAt(i) + "";
            list.set(index, temp);
            if(goDown)
            {
                if(index == nRows - 1)
                {
                    goDown = false;
                    index--;
                }
                else index++;
            }
            else
            {
                if(index == 0)
                {
                    goDown = true;
                    index++;
                }
                else index--;
            }
        }
        StringBuilder result = new StringBuilder();
        for(String sub : list) result.append(sub);
        return result.toString();
    }
    public static void main(String[] args)
    {
        String s = "ABC";
        System.out.println(convert(s, 2));
    }
   
}
