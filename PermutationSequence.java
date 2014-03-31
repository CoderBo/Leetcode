/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;


/**
 * problem:Given n and k, return the kth permutation sequence.
 * @author chenbo
 */
public class PermutationSequence 
{
    static String getPermutation(int n, int k)
    {
        k--;
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++) numbers.add(i);
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++) factorial[i] = factorial[i - 1] * i;
        String result = "";
        for(int i = 1; i <= n; i++)
        {
            int index = k / factorial[n - i];
            result += numbers.get(index);
            numbers.remove(index);
            k = k % factorial[n - i];
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(getPermutation(3, 4));
    }
}
