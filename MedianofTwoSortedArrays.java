/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * @author chenbo
 */
public class MedianofTwoSortedArrays 
{
    static double findMedianSortedArrays(int A[], int B[])
    {
        int[] array = new int[A.length + B.length];
        int p = 0, q = 0;
        int i = 0;
        while(p < A.length && q < B.length)
        {
            if(A[p] < B[q]) array[i++] = A[p++];
            else array[i++] = B[q++];
        }
        while(p < A.length)
        {
            array[i++] = A[p++];
        }
        while(q < B.length)
        {
            array[i++] = B[q++];
        }
        if(array.length % 2 != 0) return array[array.length / 2];
        else 
        {
            System.out.println(array[array.length / 2] + " " + array[array.length / 2 - 1]);
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0;
        }
    }
    public static void main(String[] args)
    {
        int[] a = {1,1};
        int[] b = {1,2};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
