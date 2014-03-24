/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given an array of non-negative integers, you are initially positioned at
 * the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * @author chenbo
 */
public class JumpGameII 
{
    public int jump(int[] A) {
        int step = 0;
        int last = 0;
        int oneMoreStep = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(i > last)
            {
                last = oneMoreStep;
                step++;
            }
            oneMoreStep = Math.max(oneMoreStep, i + A[i]);
        }
        return step;
    }
}
