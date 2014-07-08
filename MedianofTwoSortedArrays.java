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
    
    static int findKth(int[] A, int[] B, int aStart, int aEnd, int bStart, int bEnd, int k)
    {
        int aLength = aEnd - aStart + 1;
        int bLength = bEnd - bStart + 1;
        if(aLength > bLength) return findKth(B, A, bStart, bEnd, aStart, aEnd, k);
        if(aEnd < aStart) return B[bStart + k];
        if(k == 1) return Math.min(A[aStart], B[bStart]);
        int pa = Math.min(k / 2, aLength);
        int pb = k - pa;
        if(A[aStart + pa - 1] == B[bStart + pb - 1]) return A[aStart + pa - 1];
        else if(A[aStart + pa - 1] < B[bStart + pb - 1]) return findKth(A, B, aStart + pa, aEnd, bStart, bEnd, k - pa);
        else return findKth(A, B, aStart, aEnd, bStart, bEnd - pb, k - pb);
    }
    static double findKth(int[] A, int[] B, int k)
    {
        return findKth(A, B, 0, A.length - 1, 0, B.length - 1, k);
    }
    public static void main(String[] args)
    {
        int[] a = {1,3,4,5,7,9,12};
        int[] b = {2,4,5,8,11,13};
        System.out.println(findKth(a, b, 3));
    }
}
