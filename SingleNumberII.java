/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given an array of integers, 
 * every element appears three times except for one. Find that single one.
 * @author chenbo
 */
public class SingleNumberII 
{
    static int singleNumber(int[] A) 
    {
        int one = 0;
        int two = 0;
        int three;
        for(int i : A)
        {
            two |= one & i;
            one ^= i;
            three = one & two;
            one = ~three & one;
            two = ~three & two;
        }
        return one;
    }
    public static void main(String[] args)
    {
        int[] array = {2,5,9,2,1,9,5,5,2,9};
        System.out.println(singleNumber(array));
    }
}
