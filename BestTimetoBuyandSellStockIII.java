/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import static leetcode.BestTimetoBuyandSellStockII.maxProfit;

/**
 * problem:Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * @author chenbo
 */
public class BestTimetoBuyandSellStockIII 
{
    static int maxProfit(int[] prices)
    {
        if(prices.length <= 1) return 0;
        int[] maxEndWith = new int[prices.length];
        int maxDifference = 0;
        int lowest = prices[0];
        for(int i = 1; i < prices.length; i++)
        {
            int difference = prices[i] - lowest;
            if(difference > maxDifference) maxDifference = difference;
            maxEndWith[i] = maxDifference;
            if(prices[i] < lowest) lowest = prices[i];
        }
        int result = 0;
        int highest = prices[prices.length - 1];
        int maxRight = 0;
        for(int i = prices.length - 2; i >= 0; i--)
        {
            int difference = highest - prices[i];
            if(difference > maxRight) maxRight = difference;
            if(result < maxRight + maxEndWith[i]) result = maxRight + maxEndWith[i];
            if(prices[i] > highest) highest = prices[i];
        }
        return result;
        
    }

    public static void main(String[] args)
    {
        int[] array = {1,2};
        System.out.println(maxProfit(array));
    }
}
