/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a sorted array, remove the duplicates in place 
 * such that each element appear only once and return the new length.


 * @author chenbo
 */
public class RemoveDuplicatesfromSortedArray 
{
    static int removeDuplicates(int[] A)
    {
        int current = 0;
        int i = 1;
        if(A.length <= 1) return A.length;
        while(i < A.length)
        {
            if(A[current] == A[i]) i++;
            else A[++current] = A[i++];
        }
        return current + 1;
    }
    public static void main(String[] args)
    {
        int[] array = {1,1,1,2,2,2,3};
        System.out.println(removeDuplicates(array));
        for(int i : array)
        {
            System.out.println(i);
        }
    }
}
