/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
 * @author chenbo
 */
public class SpiralMatrix 
{
    static enum Direction
    {
        left, right, up, down 
    }
    static ArrayList<Integer> spiralOrder(int[][] matrix)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        int i = 0;
        int j = -1;
        int value = 1;
        int n = matrix.length;
        int m = matrix[0].length;
        Direction direction = Direction.right;
        while(result.size() < m * n)
        {
            System.out.println(direction);
            if(direction == Direction.right)
            {
                if(j == m - 1 || matrix[i][j + 1] == Integer.MAX_VALUE)
                {
                    direction = Direction.down;
                    continue;
                }
                else 
                {
                    int temp = matrix[i][++j];
                    result.add(temp);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
            else if(direction == Direction.down)
            {
                if(i == n - 1 || matrix[i + 1][j] == Integer.MAX_VALUE)
                {
                    direction = Direction.left;
                    continue;
                }
                else
                {
                    int temp = matrix[++i][j];
                    result.add(temp);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
            else if(direction == Direction.left)
            {
                if(j == 0 || matrix[i][j - 1] == Integer.MAX_VALUE)
                {
                    direction = Direction.up;
                    continue;
                }
                else
                {
                    int temp = matrix[i][--j];
                    result.add(temp);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
            else if(direction == Direction.up)
            {
                if(i == 0 || matrix[i - 1][j] == Integer.MAX_VALUE)
                {
                    direction = Direction.right;
                    continue;
                }
                else
                {
                    int temp = matrix[--i][j];
                    result.add(temp);
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[][] array = {{2,5},{8,4},{0,-1}};
        System.out.println(spiralOrder(array));
    }
}
