/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * problem:Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area.
 * @author chenbo
 */
public class MaximalRectangle 
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
    static int maximalRectangle(char[][] matrix)
    {
        int result = 0;
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int[][] height = new int[m][n + 1];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == '0') height[i][j] = 0;
                else
                {
                    if(i == 0) height[i][j] = 1;
                    else height[i][j] = height[i - 1][j] + 1;
                }
            }
        }
        for(int i = 0; i < m; i++)
        {
            int temp = largestRectangleArea(height[i]);
            if(temp > result) result = temp;
        }
        return result;
    }
    public static void main(String[] args)
    {
        char[][] matrix = {{'0','0','0','1','1','1'},
                          {'0','0','0','1','1','1'},
                          {'0','0','0','1','1','1'},
                          {'0','1','1','0','1','0'}
        };
        System.out.println(maximalRectangle(matrix));
        
    }
    
}
