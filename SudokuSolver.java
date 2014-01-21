/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * problem:Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * @author chenbo
 */
public class SudokuSolver 
{
    static boolean check(ArrayList<Character> list)
    {
        HashSet<Character> set = new HashSet<Character>();
        for(char c : list)
        {
            if(set.contains(c)) return false;
            else set.add(c);
        }
        return true;
    }
    static boolean isValidSudoku(char[][] board, int x, int y)
    {   
        ArrayList<Character> line = new ArrayList<Character>();
        for(int j = 0; j < board[0].length; j++)
        {
            if(board[x][j] != '.') line.add(board[x][j]);
        }
        if(check(line) == false) return false;    
        line.removeAll(line);
        for(int i = 0; i < board.length; i++)
        {
            if(board[i][y] != '.') line.add(board[i][y]);
        }
        if(check(line) == false) return false;     
        line.removeAll(line);
        int m = (x / 3) * 3;
        int n = (y / 3) * 3;
        
        for(int i = m; i < m + 3; i++)
        {
            for(int j = n; j < n + 3; j++)
            {
                if(board[i][j] != '.') line.add(board[i][j]);
            }
        }
        if(check(line) == false) return false;
        return true;
    }
    static boolean solve(char[][] board)
    {
        if(board == null) return false;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char k = '1'; k <= '9'; k++)
                    {
                        board[i][j] = k;
                        if(isValidSudoku(board, i, j) && solve(board))
                            return true;
                        else board[i][j] = '.';   
                    }
                    return false;
                }
            }
        }
        return true;
    }
    static void solveSudoku(char[][] board)
    {
        solve(board);
    }
    public static void main(String[] args)
    {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};
        
        solveSudoku(board);
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
