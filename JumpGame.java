/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:iven an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * @author chenbo
 */
public class JumpGame 
{
    static boolean canJump(int[] A)
    {
        if(A.length == 0) return false;
        return canJump(A, 0, new int[A.length]);
    }
    static boolean canJump(int[] A, int start, int[] dp)
    {
        if(dp[start] == 1) return true;
        if(dp[start] == -1) return false;
        if(start >= A.length - 1) return true;
        int step = A[start];
        if(step >= A.length - 1 - start) 
        {
            dp[start] = 1;
            return true;
        }
        for(int i = 1; i <= step; i++)
        {
            if(canJump(A, start + i, dp))
            {
                dp[start] = 1;
                return true;
            }
        }
        dp[start] = -1;
        return false;
    }
    static boolean canJump2(int[] A)
    {
        int maxx=0;  
        for(int i = 0; i < A.length; i++)  
        {  
            if(i <= maxx)  
            {  
                maxx = Math.max(maxx, i + A[i]);  
            }  
        }  
        return maxx >= A.length - 1;
    }
    public static void main(String[] args)
    {
        int[] array = new int[25003];
        int j = 0;
        for(int i = 25000; i >= 1; i--)
        {
            array[j++] = i;
        }
        System.out.println(array[25000]);
        System.out.println(canJump2(array));
    }
}
