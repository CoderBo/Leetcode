/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * problem:Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * @author chenbo
 */
public class ThreeSum 
{
    static ArrayList<ArrayList<Integer>> TwoSum(int[] num, int target, int start)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashSet<Integer> set = new HashSet<Integer>();
        int i = start;
        int j = num.length - 1;
        while(i < j)
        {          
            if(target == num[i] + num[j])
            {
                ArrayList<Integer> sub = new ArrayList<Integer>();
                sub.add(num[i]);
                sub.add(num[j]);
                if(!set.contains(num[i])) 
                {
                    result.add(sub);
                    set.add(num[i]);
                }
                i++;
                j--;
            }
            else if(num[i] + num[j] < target)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return result;
    }
    static ArrayList<ArrayList<Integer>> threeSum(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 1; i++)
        {
            int target = 0 - num[i];
            ArrayList<ArrayList<Integer>> sub = TwoSum(num, target, i + 1);
            for(ArrayList<Integer> s : sub)
            {
                ArrayList<Integer> subResult = new ArrayList<Integer>();
                subResult.add(num[i]);
                subResult.addAll(s);
                if(!result.contains(subResult))
                {
                    result.add(subResult);
                    set.add(subResult);
                }
            }
        }
        return result;
    }
    public static void main(String[] arg)
    {
        int[] num = {-1,0,1,2,-1,-4};
        System.out.println(TwoSum(num, 0, 0));
    }
}
