/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;


/**
 * problem:A robot is located at the top-left
 * corner of a m x n grid (marked 'Start' in the diagram below).
 * @author chenbo
 */
public class UniquePaths 
{
    static int uniquePaths(int m, int n)
    {
        if(m == 0) return 0;
        else 
        {
            int[][] dp = new int[m][n];
            return uniquePaths2(m - 1, n - 1, dp);
        }
    }
    static int uniquePaths2(int x, int y, int[][] dp)
    {
        if(dp[x][y] != 0) return dp[x][y];
        if(x == 0 && y == 0) return 1;
        if(x == 0) return uniquePaths2(x, y - 1, dp);
        if(y == 0) return uniquePaths2(x - 1, y, dp);
        else
        {
            dp[x][y] = uniquePaths2(x - 1, y, dp) + uniquePaths2(x, y - 1, dp);
            return dp[x][y];
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(uniquePaths(2, 2));
    }
}
