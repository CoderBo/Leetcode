/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Find the contiguous subarray within an array
 * (containing at least one number) which has the largest sum.
 * @author chenbo
 */
public class MaximumSubarray 
{
    static int maxSubArray(int[] A)
    {
        int result = Integer.MIN_VALUE;
        int tempMax = 0;
        for(int i : A)
        {
            tempMax += i;
            if(result < tempMax) result = tempMax;
            if(tempMax < 0) tempMax = 0;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] array = {-2,0,-2,-3,-10};
        System.out.println(maxSubArray(array));
    }
}
