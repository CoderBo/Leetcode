/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * @author chenbo
 */
public class MinimumPathSum 
{
    static int minPathSum(int[][] grid)
    {
        int[][] dp = new int[grid.length][grid[0].length];
        if(grid.length == 0) return 0;
        else return minPathSum(grid, grid.length - 1, grid[0].length - 1, dp);
    }
    static int minPathSum(int[][] grid, int x, int y, int[][] dp)
    {
        if(dp[x][y] != 0) return dp[x][y];
        if(x == 0 && y == 0) return grid[x][y];
        if(x == 0) return grid[x][y] + minPathSum(grid, x, y - 1, dp);
        if(y == 0) return grid[x][y] + minPathSum(grid, x - 1, y, dp);
        else
        {
            dp[x][y] = grid[x][y] + Math.min(minPathSum(grid,x - 1, y, dp), minPathSum(grid, x, y - 1, dp));
            return dp[x][y];
        }
    }
    public static void main(String[] args)
    {
        int[][] grid = {{0,0}};
        System.out.println(minPathSum(grid));
    }
}
