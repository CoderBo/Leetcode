/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 * @author chenbo
 */
public class LongestPalindromicSubstring 
{
    static boolean checkPalindrom(String s)
    {
        String s2 = new StringBuilder(s).reverse().toString();
        return s.equals(s2);
    }
    static String findLCS(String s1, String s2)
    {
        int[][] matrix = new int[s1.length()][s2.length()];
        int max = 0;
        int index = 0;
        for(int i = 0; i < s1.length(); i++)
        {
            for(int j = 0; j < s2.length(); j++)
            {
                if(s1.charAt(i) == s2.charAt(j))
                {
                    if(i >= 1 && j >= 1)
                    {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    else
                    {
                        matrix[i][j] = 1;
                    }
                    if(max < matrix[i][j]) 
                    {
                        index = j;
                        max = matrix[i][j];
                    }
                }
            }
        }
        
        return s2.substring(index - max + 1, index + 1);
    }
    static String longestPalindrome(String s) 
    {
        String reverse = new StringBuilder(s).reverse().toString();
        if(checkPalindrom(s)) return s;
        while(true)
        {
            String result = findLCS(s, reverse);
            if(checkPalindrom(result)) return result;
            else
            {
                //StringBuilder temp = new StringBuilder(reverse);
                reverse = reverse.replaceFirst(result, "");
            }
         }
    }
    public static void main(String[] args)
    {
        System.out.println(findLCS("21232523311324", "312123223445"));
        String a = "aaa";
        String b = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        System.out.println(longestPalindrome(b));
        System.out.println(b.length());
    }
}
