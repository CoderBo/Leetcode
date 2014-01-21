/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Write a function to find the longest common prefix string amongst an array of strings.
 * @author chenbo
 */
public class LongestCommonPrefix 
{
    static String longestCommonPrefix(String[] strs)
    {
        if(strs.length == 0) return "";
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++)
        {
            char temp = strs[0].charAt(i);
            boolean isCommon = true;
            for(int j = 1; j < strs.length; j++)
            {
                String s = strs[j];
                if(s.length() <= i || s.charAt(i) != temp) 
                {
                    isCommon = false;
                    break;
                }
            }
            if(isCommon) result.append(temp);
            else break;
        }
        return result.toString();
    }
    public static void main(String[] args)
    {
        String[] array = {"aa", "a", "a"};
        System.out.println(longestCommonPrefix(array));
    }
}
