/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Say you have an array for which the ith 
 * element is the price of a given stock on day it.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 * @author chenbo
 */
public class BestTimetoBuyandSellStockII 
{
    static int maxProfit(int[] prices)
    {
        int result = 0;
        for(int i = 1; i < prices.length; i++)
        {
            if(prices[i] > prices[i - 1]) result += prices[i] - prices[i - 1];
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] array = {2,6,5,1,3,8,4,7};
        System.out.println(maxProfit(array));
    }
}
