/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water it is able to 
 * trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author chenbo
 */
public class TrappingRainWater 
{
    static int trap(int[] A)
    {
        if(A.length <= 2) return 0;
        int result = 0;
        int[] leftHighest = new int[A.length];
        leftHighest[0] = 0;
        int max = A[0];
        for(int i = 1; i < leftHighest.length - 1; i++)
        {
            leftHighest[i] = max;
            if(max < A[i]) max = A[i];
        }
        max = A[A.length - 1];
        int rightHighest = 0;
        for(int i = A.length - 2; i > 0; i--)
        {
            rightHighest = max;
            if(max < A[i]) max = A[i];
            int temp = Math.min(leftHighest[i], rightHighest) - A[i];
            if(temp > 0) result += temp;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(array));
    }
}
