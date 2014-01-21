/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Hashtable;

/**
 * problem:You are climbing a stair case. 
 * It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * @author chenbo
 */
public class ClimbingStairs 
{
    static Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
    static int climbStairs(int n)
    {
        if(table.containsKey(n)) return table.get(n);
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        table.put(n, result);
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(climbStairs(38));
    }
}
