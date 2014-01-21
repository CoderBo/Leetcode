/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy。
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * @author chenbo
 */
public class Candy 
{
    static int candy(int[] ratings)
    {
        int[] array = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++) array[i] = 1;
        for(int i = 1; i < ratings.length; i++)
            if(ratings[i] > ratings[i - 1]) array[i] = array[i - 1] + 1;
        for(int i = ratings.length - 2; i >= 0; i--)
            if(ratings[i] > ratings[i + 1])
                if(array[i] <= array[i + 1]) array[i] = array[i + 1] + 1;
        int result = 0;
        for(int i : array) result += i;
        return result;
    }
    public static void main(String[] args)
    {
        int[] ratings = {1,2,4,4,3};
        
        System.out.println(candy(ratings));
    }
}
