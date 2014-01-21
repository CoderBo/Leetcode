/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given an array of integers, 
 * every element appears twice except for one. Find that single one.
 * @author chenbo
 */
public class SingleNumber 
{
    static int singleNumber(int[] A)
    {
        int result = 0;
        for(int i : A)
        {
            result ^= i;
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] array = {2,5,9,2,1,9,5};
        System.out.println(singleNumber(array));
    }
}
