/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given two words word1 and word2, find the minimum number of steps 
 * required to convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * @author chenbo
 */
public class EditDistance 
{
    static int minDistance(String word1, String word2)
    {
        int m = word1.length();
        int n = word2.length();
        int[][] distance = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++)
        {
            for(int j = 0; j <= n; j++)
            {
                if(j == 0) distance[i][j] = i;
                else if(i == 0) distance[i][j] = j;
                else
                {
                    distance[i][j] = Math.min(Math.min(distance[i - 1][j] + 1, 
                            distance[i][j - 1] + 1), distance[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
                }
            }
        }
        return distance[m][n];
    }
    public static void main(String[] args)
    {
        System.out.println(minDistance("ne", "worker"));
    }
}
