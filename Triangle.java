/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * problem:Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * @author chenbo
 */
public class Triangle 
{
    static int minimumTotal(ArrayList<ArrayList<Integer>> triangle)
    {
        int size = triangle.get(triangle.size() - 1).size();
        int [][] dp = new int[size][size];
        return minimumTotal(triangle, 0, 0, dp);
    }
    static int minimumTotal(ArrayList<ArrayList<Integer>> triangle, int i , int j, int[][] dp)
    {
        if(dp[i][j] != 0) return dp[i][j];
        if(triangle.isEmpty()) return 0;
        if(i == triangle.size() - 1)
            return triangle.get(i).get(j);
        int result =  triangle.get(i).get(j) + Math.min(minimumTotal(triangle, i + 1 , j, dp), minimumTotal(triangle, i + 1, j + 1, dp));
        dp[i][j] = result;
        return result;
    }
    
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(2);
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(3);
        b.add(4);
        ArrayList<Integer> c = new ArrayList<Integer>();
        c.add(6);
        c.add(5);
        c.add(7);
        ArrayList<Integer> d = new ArrayList<Integer>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        triangle.add(a);
        triangle.add(b);
        triangle.add(c);
        triangle.add(d);
        System.out.println(minimumTotal(triangle));
    }
}
