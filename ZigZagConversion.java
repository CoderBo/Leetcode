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
    static String convert(String s, int nRows)
    {
        if(nRows == 1) return s;
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < nRows; i++)
        {
            ArrayList<String> sub = new ArrayList<String>();
            result.add(sub);
        }
        boolean inorder = true;
        int index = 0;
        for(int i = 0; i < s.length(); i++)
        {
           
            StringBuilder temp = new StringBuilder();
            temp.append(s.charAt(i));
            String word = temp.toString();
            if(inorder)
            {
                result.get(index).add(word);
                index++;
                if(index >= nRows)
                {
                    inorder = false;
                    index -= 2;
                }
            }
            else
            {
                result.get(index).add(word);
                index--;
                if(index < 0)
                {
                    inorder = true;
                    index += 2;
                }
            }
        }
        StringBuilder newResult = new StringBuilder();
        for(ArrayList<String> i : result)
        {
            for(String j : i)
            {
                newResult.append(j);
            }
        }
        return newResult.toString();
    }
    public static void main(String[] args)
    {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 1));
    }
   
}
