/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import static leetcode.ThreeSum.TwoSum;
import static leetcode.ThreeSum.threeSum;

/**
 * problem:Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * @author chenbo
 */
public class FourSum 
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
    static ArrayList<ArrayList<Integer>> threeSum(int[] num, int target, int start)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = start; i < num.length - 1; i++)
        {
            int target2 = target - num[i];
            ArrayList<ArrayList<Integer>> sub = TwoSum(num, target2, i + 1);
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
    static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < num.length; i++)
        {
            int target2 = target - num[i];
            ArrayList<ArrayList<Integer>> sub = threeSum(num, target2, i + 1);
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
        int[] num = {8,-15,-2,-13,8,5,6,-3,-9,3,6,-6,8,14,-9,-8,-9,-6,-14,5,-7,3,-10,-14,-12,-11,12,-15,-1,12,8,-8,12,13,-13,-3,-5,0,10,2,-11,-7,3,4,-8,9,3,-10,11,5,10,11,-7,7,12,-12,3,1,11,9,-9,-4,9,-12,-6,11,-7,4,-4,-12,13,-8,-12,2,3,-13,-12,-8,14,14,12,9,10,12,-6,-1,8,4,8,4,-1,14,-15,-7,9,-14,11,9,5,14};
        System.out.println(fourSum(num, 0));
    }
}
