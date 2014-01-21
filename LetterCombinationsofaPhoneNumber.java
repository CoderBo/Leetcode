/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * problem:Given a digit string, 
 * return all possible letter combinations that the number could represent.
 * @author chenbo
 */
public class LetterCombinationsofaPhoneNumber 
{
    static Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
    static ArrayList<String> letterCombinations(String digits)
    {
        String[] num = new String[10];
        num[2] = "abc";
        num[3] = "def";
        num[4] = "ghi";
        num[5] = "jkl";
        num[6] = "mno";
        num[7] = "pqrs";
        num[8] = "tuv";
        num[9] = "wxyz";
        return letterCombinations(digits, num);
    }
    static ArrayList<String> letterCombinations(String digits, String[] num)
    {
        if(table.containsKey(digits)) return table.get(digits);
        ArrayList<String> result = new ArrayList<String>();
        char first = ' ';
        String remain = "";
        boolean flag = false;
        for(int i = 0; i < digits.length(); i++)
        {
            char temp = digits.charAt(i);
            if(temp >= '2' && temp <= '9')
            {
                first = temp;
                remain = digits.substring(i + 1);
                flag = true;
                break;
            }
        }
        if(flag == false)
        {
            result.add("");
            return result;
        }
        int index = Character.getNumericValue(first);
        ArrayList<String> sub = letterCombinations(remain, num);
        for(char c : num[index].toCharArray())
        {  
            for(String s : sub)
            {
                result.add(c + s);
            }
        }
        table.put(digits, result);
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(letterCombinations("23"));
    }
}
