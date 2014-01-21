/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;
/**
 * problem:Now, instead outputting board configurations, 
 * return the total number of distinct solutions.
 * @author chenbo
 */
public class NQueensII 
{
    static int totalNQueens(int n)
    {
        int[] result = new int[1];
        int[] columns = new int[n];
        placeQueens(0, n, columns, result);
        return result[0];
    }
    static void placeQueens(int row, int n, int[] columns, int [] result)
    {
        if(row == n)
        {
            result[0]++;
        }
        else
        {
            for(int col = 0; col < n; col++)
            {
                if(check(columns, row, col))
                {
                    columns[row] = col;
                    placeQueens(row + 1, n, columns, result);
                }
            }
        }
    }
    static boolean check(int[] columns, int row, int column)
    {
        for(int row2 = 0; row2 < row; row2++)
        {
            int column2 = columns[row2];
            if(column2 == column) return false;
            int columnDistance = Math.abs(column2 - column);
            int rowDistance = row - row2;
            if(rowDistance == columnDistance) return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        System.out.println(totalNQueens(4));
    }
}
