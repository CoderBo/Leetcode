/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * @author chenbo
 */
public class SetMatrixZeroes 
{
    static void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(row[i] || column[j])
                    matrix[i][j] = 0;
            }
        }
    }
    static void setZeroes2(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        for(int i = 0; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0) 
            {
                firstRowZero = true;
                break;
            }
        }
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0) 
            {
                firstColumnZero = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRowZero)
        {
            for(int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
        if(firstColumnZero)
        {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
    public static void main(String[] args)
    {
        int[][] matrix = {{0,1}};
        setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
