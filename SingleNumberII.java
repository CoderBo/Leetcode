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
    static int singleNumber2(int[] A) {
        int[] count = new int[32];
        int flag = 0;
        int result = 0;
        for(int i : A)
        {
            if(i < 0)
            {
                flag = (flag + 1) % 3;
                i = -i;
            }
            for(int j = 0; j < 32; j++)
            {
                if((i & (1 << j)) != 0) 
                    count[j] = (count[j] + 1) % 3;
            }
        }
        for(int i = 0; i < 32; i++)
            result |= count[i] << i;
        return flag == 1? -result : result;
    }
    public static void main(String[] args)
    {
        int[] array = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
        System.out.println(singleNumber2(array));
    }
}
