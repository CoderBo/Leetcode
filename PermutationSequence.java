/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;


/**
 * problem:Given n and k, return the kth permutation sequence.
 * @author chenbo
 */
public class PermutationSequence 
{
    static int factorial(int n)
    {
        if(n == 1 || n == 0) return 1;
        else return n * factorial(n - 1);
    }
    static String getPermutation(int n, int k)
    {
        String result = "";
        int[] num = new int[n];
        k--;
        for(int i = 0; i < n; i++)
        {
            num[i] = i + 1;
        }
        for(int i = n - 1; i >= 0; i--)
        {
            int times = k / factorial(i);
            for(int j = 0; j <= times; j++)
            {
                if(num[j] == -1) times++;
            }
            result += num[times];
            num[times] = -1;
             
        }
        return result;
        
    }
    public static void main(String[] args)
    {
        System.out.println(getPermutation(3, 4));
    }
}
