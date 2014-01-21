/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.HashSet;
import java.util.Hashtable;

/**
 * problem:Given an array of integers, 
 * find two numbers such that they add up to a specific target number.
 * @author chenbo
 */
public class TwoSum 
{
    static int[] twoSum(int[] numbers, int target)
    {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        int[] result = new int[3];
        for(int i = 0; i < numbers.length; i++)
        {
            if(table.containsValue(target - numbers[i]))
            {
                int j = 0;
                for(int n = 0; n < numbers.length && n != i; n++)
                {
                    if(numbers[n] == target - numbers[i]) j = n;
                }
                if(i < j)
                {
                    result[0] = i + 1;
                    result[1] = j + 1;
                }
                else
                {
                    result[0] = j + 1;
                    result[1] = i + 1;
                }
                break;
            }
            else table.put(i, numbers[i]);
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] numbers = {-1,0,1,2,-1,-4};
        System.out.println(twoSum(numbers, 0)[0] + " " + twoSum(numbers, 0)[1]);
    }
}
