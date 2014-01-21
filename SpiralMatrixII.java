/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given an integer n, generate a square matrix
 * filled with elements from 1 to n2 in spiral order.
 * @author chenbo
 */
public class SpiralMatrixII 
{
    static enum Direction
    {
        left, right, up, down 
    }
    static int[][] generateMatrix(int n)
    {
        int[][] matrix = new int[n][n];
        int i = 0;
        int j = -1;
        int value = 1;
        Direction direction = Direction.right;
        while(value <= n * n)
        {
            if(direction == Direction.right)
            {
                if(j == n - 1 || matrix[i][j + 1] != 0)
                {
                    direction = Direction.down;
                    continue;
                }
                else matrix[i][++j] = value++;
            }
            else if(direction == Direction.down)
            {
                if(i == n - 1 || matrix[i + 1][j] != 0)
                {
                    direction = Direction.left;
                    continue;
                }
                else matrix[++i][j] = value++;
            }
            else if(direction == Direction.left)
            {
                if(j == 0 || matrix[i][j - 1] != 0)
                {
                    direction = Direction.up;
                    continue;
                }
                else matrix[i][--j] = value++;
            }
            else if(direction == Direction.up)
            {
                if(i == 0 || matrix[i - 1][j] != 0)
                {
                    direction = Direction.right;
                    continue;
                }
                else matrix[--i][j] = value++;
            }
        }
        return matrix;
    }
    public static void main(String[] args)
    {
        int[][] matrix = generateMatrix(4);
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                System.out.print(matrix[i][j] + "         ");
            }
            System.out.println("");
        }
    }
}
