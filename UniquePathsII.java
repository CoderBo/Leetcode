/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Now consider if some obstacles are added to the grids. 
 * How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * @author chenbo
 */
public class UniquePathsII 
{
    static int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        if(obstacleGrid.length == 0) return 0;
        else
        {
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            return uniquePathsWithObstacles(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, dp);
        }
    }
    static int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y, int[][] dp)
    {
        if(dp[x][y] != 0)
        {
            System.out.println("x = " + x + " y = " + y);
            return dp[x][y];
        }
        if(x == 0 && y == 0 && obstacleGrid[x][y] != 1) return 1;
        if(obstacleGrid[x][y] == 1) return 0;
        if(x == 0) return uniquePathsWithObstacles(obstacleGrid, x, y - 1, dp);
        if(y == 0) return uniquePathsWithObstacles(obstacleGrid, x - 1, y, dp);
        else
        {
            dp[x][y] = uniquePathsWithObstacles(obstacleGrid, x - 1, y, dp) + uniquePathsWithObstacles(obstacleGrid, x, y - 1, dp);
            return dp[x][y];
        }
    }
    
    static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles2(obstacleGrid, 0, 0, dp);
    }
    static int uniquePathsWithObstacles2(int[][] obstacleGrid, int x, int y, int[][] dp)
    {
        if(dp[x][y] != 0) 
        {
            System.out.println("x = " + x + " y = " + y);
            return dp[x][y];
        }
        if(obstacleGrid[x][y] == 1) return 0;
        if(x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) return 1;     
        if(x == obstacleGrid.length - 1)
        {
            dp[x][y] = uniquePathsWithObstacles2(obstacleGrid, x, y + 1, dp);
            return dp[x][y];
        }
        if(y == obstacleGrid[0].length - 1)
        {
            dp[x][y] = uniquePathsWithObstacles2(obstacleGrid, x + 1, y, dp);
            return dp[x][y];
        }
        else
        {
            dp[x][y] = uniquePathsWithObstacles2(obstacleGrid, x + 1, y, dp) + uniquePathsWithObstacles2(obstacleGrid, x, y + 1, dp);
            return dp[x][y];
        }
    }
    public static void main(String[] args)
    {
        int[][] grid = {{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles2(grid));
    }
}
