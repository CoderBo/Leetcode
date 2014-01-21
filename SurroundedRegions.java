/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import javax.management.Query;

/**
 * problem:
 * @author chenbo
 */
public class SurroundedRegions 
{
    static void solve(char[][] board)
    {
        int m = board.length;
        if(m == 0) return;
        int n = board[0].length;
        Queue<Integer> queueX = new LinkedList<Integer>();
        Queue<Integer> queueY = new LinkedList<Integer>();
        for(int i = 0; i < m; i++)
        {
            if(board[i][0] == 'O')
            {
                queueX.offer(i);
                queueY.offer(0);
            }
            if(board[i][n - 1] == 'O')
            {
                queueX.offer(i);
                queueY.offer(n - 1);
            }
        }
        for(int j = 0; j < n; j++)
        {
            if(board[0][j] == 'O')
            {
                queueX.offer(0);
                queueY.offer(j);
            }
            if(board[m - 1][j] == 'O')
            {
                queueX.offer(m - 1);
                queueY.offer(j);
            }
        }
        
        while(!queueX.isEmpty())
        {
            
            int x = queueX.poll();
            int y = queueY.poll();
            board[x][y] = 'A';
            if(x - 1 >= 0 && board[x - 1][y] == 'O')
            {
                queueX.offer(x - 1);
                queueY.offer(y);
            }
            if(x + 1 < m && board[x + 1][y] == 'O')
            {
                queueX.offer(x + 1);
                queueY.offer(y);
            }
            if(y - 1 >= 0 && board[x][y - 1] == 'O')
            {
                queueX.offer(x);
                queueY.offer(y - 1);
            }
            if(y + 1 < n && board[x][y + 1] == 'O')
            {
                queueX.offer(x);
                queueY.offer(y + 1);
            }
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'A') board[i][j] = 'O';
            }                                          
        }
    }
    
   
    public static void main(String[] args)
    {
        char[][] board = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','O','O','O'},
                          {'X','X','X','O'}};
        solve(board);
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