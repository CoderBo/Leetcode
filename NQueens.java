/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Given an integer n, 
 * return all distinct solutions to the n-queens puzzle.
 * @author chenbo
 */
public class NQueens 
{
    static ArrayList<String[]> solveNQueens(int n)
    {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] columns = new int[n];
        placeQueens(0, n, columns, result);
        return result;
    }
    static void placeQueens(int row, int n, int[] columns, ArrayList<String[]> result)
    {
        if(row == n)
        {
            String[] temp = new String[n];
            for(int i = 0; i < n; i++)
            {
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < n; j++)
                {
                    if(j == columns[i]) s.append("Q");
                    else s.append(".");
                }
                temp[i] = s.toString();
            }
            result.add(temp);
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
        System.out.println(solveNQueens(1).size());
    }
}
