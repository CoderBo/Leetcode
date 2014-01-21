/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import static leetcode.RemoveDuplicatesfromSortedArray.removeDuplicates;

/**
 * problem:What if duplicates are allowed at most twice?
 * @author chenbo
 */
public class RemoveDuplicatesfromSortedArrayII 
{
    static int removeDuplicates(int[] A)
    {
        int state = 1;
        if(A.length <= 1) return A.length;
        int i = 0;
        for(int j = 1; j < A.length; j++)
        {
           /// System.out.println("i: " + i + " j: " + j);
            if(A[j] != A[i])
            {
                A[++i] = A[j];
                state = 1;
            }
            else if(A[j] == A[i] && state == 1)
            {
                A[++i] = A[j];
                state = 2;
            }
        }
        return i + 1;
    }
    public static void main(String[] args)
    {
        int[] array = {1,1,1,1,3,3};
        System.out.println(removeDuplicates(array));
        for(int i : array)
        {
            System.out.print(i);
        }
    }
}
