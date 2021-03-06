/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * @author chenbo
 */
public class ContainerWithMostWater 
{
    static int maxArea(int[] height)
    {
        int capacity = 0;
        int area;
        int i = 0;
        int j = height.length - 1;
        while(i < j)
        {
            area = Math.min(height[i], height[j]) * (j - i);
            if(capacity < area) capacity = area;
            
            if(height[i] < height[j]) i++;
            else j--;
        }
        return capacity;
    }
    public static void main(String[] args)
    {
        int[] array = {2,5,1,3,1,2,1,7,7,6};
        System.out.println(maxArea(array));
    }
}   
