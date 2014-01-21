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
    static int canJump2(int[] A)
    {
        int maxx=0;
        int temp = 0;
        int num = 0;
        for(int i = 0; i < A.length;)  
        {  
            if(temp >= A.length - 1) break;
            while(i <= temp)  
            {  
                maxx = Math.max(maxx, i + A[i]); 
                i++;
            }  
            num++;
            temp = maxx;
        }  
        return num;
    }
    public static void main(String[] args)
    {
        
    }
}
