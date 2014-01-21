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
        int indexA = m - 1;
        int indexB = n - 1;
        int indexNewArray = m + n - 1;
        while(indexA >= 0 && indexB >= 0)
        {
            if(A[indexA] >= B[indexB])
            {
                A[indexNewArray] = A[indexA];
                indexA--;
            }
            else
            {
                A[indexNewArray] = B[indexB];
                indexB--;
            }
            indexNewArray--;
        }
        
        while(indexB >= 0)
        {
            A[indexNewArray] = B[indexB];
            indexB--;
            indexNewArray--;
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
