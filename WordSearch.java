/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * problem:Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * @author chenbo
 */
public class WordSearch 
{
    static boolean exist(char[][] board, String word)
    {
        if(board.length == 0) return false;
        char first = word.charAt(0);
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == first)
                {
                    if(check(i, j, board, word, new boolean[board.length][board[0].length])) return true;
                }
            }
        }
        return false;
    }
    static boolean check(int x, int y, char[][] board, String word, boolean[][] record)
    {
       // System.out.println(word + " " + x + " " + y);
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if(record[x][y] == true) return false;   
        if(word.length() == 1 && board[x][y] == word.charAt(0)) return true;
        if(board[x][y] == word.charAt(0))
        {
            record[x][y] = true;
            if(check(x - 1, y, board, word.substring(1), record) || check(x, y - 1, board, word.substring(1), record)
                    || check(x + 1, y, board, word.substring(1), record) || check(x, y + 1, board, word.substring(1), record))
                return true;
            else record[x][y] = false;
        } 
        return false;  
    }

    public static void main(String[] args)
    {
        char[][] board = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".toCharArray(),
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaab".toCharArray(),
            
                        };
        char[][] board2 = {{'A','B','C','E'},
                          {'S','F','C','S'},
                           {'A','D','E','E'}};
        
        char[][] board3 = {{'A','B'},
                          {'C','D'}};
        System.out.println(exist(board2, "ABCCED"));
          System.out.println(exist(board2, "SEE"));
        System.out.println(exist(board2, "ABCB"));
        System.out.println(exist(board3, "CDBA"));
        
        System.out.println(exist(board, "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
