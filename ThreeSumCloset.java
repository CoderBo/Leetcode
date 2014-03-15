/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Arrays;
import static leetcode.ThreeSum.threeSum;

/**
 * problem:Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 * @author chenbo
 */
public class ThreeSumCloset 
{    
    static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        if(num.length <= 2) return 0;
        int minDifference = Integer.MAX_VALUE;
        int result = 0;
        int[] position = new int[2];
        for(int i = 0; i < num.length - 2; i++)
        {
            int difference = twoSumCloset(num, target - num[i], i + 1, num.length - 1, position);
            if(difference <  minDifference) 
            {
                minDifference = difference;
                result = num[i] + num[position[0]] + num[position[1]];
            }
        }
        return result;
    }
    static int twoSumCloset(int[] num, int target, int start, int end, int[] position)
    {
        int i = start;
        int j = end;
        int minDifference = Integer.MAX_VALUE;
        int result = 0;
        while(i < j)
        {
            int difference = Math.abs(target - (num[i] + num[j]));
            if(difference < minDifference) 
            {
                minDifference = difference;
                position[0] = i;
                position[1] = j;
            }
            if(num[i] + num[j] < target) i++;
            else j--;
        }
        return minDifference;
    }
    
    public static void main(String[] arg)
    {
        int[] num = {8,-15,-2,-13,8,5,6,-3,-9,3,6,-6,8,14,-9,-8,-9,-6,-14,5,-7,3,-10,-14,-12,-11,12,-15,-1,12,8,-8,12,13,-13,-3,-5,0,10,2,-11,-7,3,4,-8,9,3,-10,11,5,10,11,-7,7,12,-12,3,1,11,9,-9,-4,9,-12,-6,11,-7,4,-4,-12,13,-8,-12,2,3,-13,-12,-8,14,14,12,9,10,12,-6,-1,8,4,8,4,-1,14,-15,-7,9,-14,11,9,5,14};
        int[] num2 = {0,0,0};
        int[] num3 = {1,2};
        System.out.println(threeSumClosest(num, 1));
        //System.out.println(twoSumClosest(num3, 0, 0));
    }
}
