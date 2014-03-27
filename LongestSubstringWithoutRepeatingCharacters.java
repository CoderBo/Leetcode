/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.HashSet;

/**
 * problem:Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * @author chenbo
 */
public class LongestSubstringWithoutRepeatingCharacters 
{
    static int lengthOfLongestSubstring(String s) {
         StringBuilder store = new StringBuilder();
         int max = 0;     
         int i = 0;
         
         while(i < s.length())
         {
             String s2 = store.toString();
             StringBuilder a = new StringBuilder();
             a.append(s.charAt(i));
             if(!s2.contains(a.toString()))
             {
                 store.append(s.charAt(i));
                 i++;
                 if(max < store.length()) max = store.length();
             }
             
             else
             {  
                 if(max < store.length()) max = store.length();
                 int index = store.indexOf(a.toString());
                 store.delete(0, index + 1);
                 store.append(s.charAt(i));
                 i++;
             }             
        }
        return max;
    }
    static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        int start = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(!set.contains(c))
            {
                set.add(c);
                max = Math.max(max, i - start + 1);
            }
            else
            {
                for(int j = start;;j++)
                {
                    if(c == s.charAt(j))
                    {
                        start = j + 1;
                        break;
                    }
                    else set.remove(s.charAt(j));
                }
            }
        }
        return max;
    }
    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring2("abcabcdd"));
    }
}
