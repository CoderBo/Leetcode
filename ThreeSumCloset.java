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
    static int twoSumClosest(int[] num, int target, int start)
    {    
        int min = Integer.MAX_VALUE;
        int result = 0;
        int i = start;
        int j = num.length - 1;
        while(i < j)
        {
            int sum = num[i] + num[j];
            int temp = Math.abs(target - sum);
            if(temp < min) 
            {
                min = temp;
                result = sum;
            }
            if(sum == target) return target;
            else if(sum < target) i++;
            else j--;
        }
        return result;
    }
    static int threeSumClosest(int[] num, int target)
    {
        Arrays.sort(num);
        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < num.length - 2; i++)
        {
            int target2 = target - num[i];
            //System.out.println("targe2:" + target2);
            int sub = twoSumClosest(num, target2, i + 1);
            //System.out.println("sub:" + sub);
            int value = Math.abs(target - sub - num[i]);
            if(value < min)
            {
                min = value;
                result = sub + num[i];
            }
        }
        return result;
    }
    public static void main(String[] arg)
    {
        int[] num = {8,-15,-2,-13,8,5,6,-3,-9,3,6,-6,8,14,-9,-8,-9,-6,-14,5,-7,3,-10,-14,-12,-11,12,-15,-1,12,8,-8,12,13,-13,-3,-5,0,10,2,-11,-7,3,4,-8,9,3,-10,11,5,10,11,-7,7,12,-12,3,1,11,9,-9,-4,9,-12,-6,11,-7,4,-4,-12,13,-8,-12,2,3,-13,-12,-8,14,14,12,9,10,12,-6,-1,8,4,8,4,-1,14,-15,-7,9,-14,11,9,5,14};
        int[] num2 = {1,2,0};
        int[] num3 = {1,2};
        System.out.println(threeSumClosest(num2, 0));
        System.out.println(twoSumClosest(num3, 0, 0));
    }
}
