/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * problem:Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * @author chenbo
 */
public class LargestRectangleinHistogram 
{
    static int largestRectangleArea(int[] height)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        
        while(i < h.length)
        {
            //System.out.println(stack);
            if(stack.isEmpty() || h[stack.peek()] <= h[i])
                stack.push(i++);
            else
            {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty()? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
    public static void main(String[] args)
    {
        int[] array = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(array));;
    }
}
