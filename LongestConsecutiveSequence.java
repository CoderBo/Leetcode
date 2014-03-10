/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * problem: Given an unsorted array of integers, 
 * find the length of the longest consecutive elements sequence.
 * @author chenbo
 */
public class LongestConsecutiveSequence 
{
    static int longestConsecutive(int[] num)
    {
        Arrays.sort(num);
        int result = -1;
        int length = 1;
        if(num.length == 1) return 1;
        for(int i = 0; i < num.length - 1; i++)
        {
            if(num[i + 1] - num[i] == 1)
            {
                length++;
            }
            else if(num[i + 1] != num[i])
            {
                if(length > result) 
                {
                    result = length;
                }
                length = 1;
            }
        }
        if(length > result) result = length;
        return result;
    }
    
    static int longestConsecutive2(int[] num) {
        if(num.length == 0) return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : num) set.add(i);
        int max = 0;
        for(int i : num)
        {
            if(!set.contains(i)) continue;
            int count = 1;
            int left = i - 1;
            int right = i + 1;
            while(set.contains(left))
            {
                count++;
                set.remove(left);
                left--;
            }
            while(set.contains(right))
            {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
    public static void main(String[] args)
    {
        int[] array = {100, 4, 2000, 1, 3 ,2};
        int[] array2 = {0,0,0};
        System.out.println(longestConsecutive2(array));
    }
}
