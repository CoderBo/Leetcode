/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

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
    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("abcabcdd"));
    }
}
