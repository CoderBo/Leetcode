/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given an array and a value,
 * remove all instances of that value in place and return the new length.
 * @author chenbo
 */
public class RemoveElement 
{
    static int removeElement(int[] A, int elem) 
    {
        int len = 0;
        for (int i = 0; i < A.length; i++)
        {   
            if (A[i] != elem)
            A[len++] = A[i];
        }
        return len;
    }
    
    public static void main(String[] args)
    {
        int[] array = {4,5};
        System.out.println(removeElement(array, 4));
    }
}
