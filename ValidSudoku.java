/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * problem:Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * @author chenbo
 */
public class ValidSudoku 
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
    static boolean isValidSudoku(char[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            ArrayList<Character> line = new ArrayList<Character>();
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != '.') line.add(board[i][j]);
            }
            if(check(line) == false) return false;
        }
        for(int i = 0; i < board[0].length; i++)
        {
            ArrayList<Character> line = new ArrayList<Character>();
            for(int j = 0; j < board.length; j++)
            {
                if(board[j][i] != '.') line.add(board[j][i]);
            }
            if(check(line) == false) return false;
        }
        for(int i = 0; i < board.length; i += 3)
        {
            for(int j = 0; j < board.length; j += 3)
            {
                ArrayList<Character> cube = new ArrayList<Character>();
                for(int m = i; m < i + 3; m++)
                {
                    for(int n = j; n < j + 3; n++)
                    {
                        if(board[m][n] != '.') cube.add(board[m][n]);
                    }
                }
                if(check(cube) == false) return false;
            }
        }
        return true;
    }
}
