/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * @author chenbo
 */
public class MergeSortedArray 
{
    static void merge(int A[], int m, int []B, int n)
    {
        int current = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(j >= 0)
        {
            if(i < 0 || A[i] < B[j]) A[current--] = B[j--];
            else A[current--] = A[i--];
        }
    }
    public static void main(String[] args)
    {
        int[] arrayA = new int [10];
        arrayA[0] = 1;
        arrayA[1] = 3;
        arrayA[2] = 5;
        arrayA[3] = 7;
        
        int[] ArrayB = {2,4,8};
        merge(arrayA, 4, ArrayB, 3);
        for(int i = 0; i < 7; i++)
        {
            System.out.print(arrayA[i]);
        }
        
    }
}
