/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * @author chenbo
 */
public class SortColors 
{
    static void sortColors(int[] A)
    {
        int numberOfZero = 0;
        int numberOfOne = 0;
        int numberOfTwo = 0;
        for(int i : A)
        {
            switch(i)
            {
                case 0: 
                    numberOfZero++;
                    break;
                case 1: numberOfOne++;
                    break;
                case 2: numberOfTwo++;
                    break;
            }
        }
        int index = 0;
        for(int i = 0; i < numberOfZero; i++)
        {
            A[index++] = 0;
        }
        for(int i = 0; i < numberOfOne; i++)
        {
            A[index++] = 1;
        }
        for(int i = 0; i < numberOfTwo; i++)
        {
            A[index++] = 2;
        }
    }
    static void sortColors2(int[] A) {
        int i = 0;
        int current = 0;
        int j = A.length - 1;
        while(current <= j)
        {
            if(A[current] == 1) current++;
            else if(A[current] == 0)
            {
                int temp = A[i];
                A[i] = A[current];
                A[current] = temp;
                i++;
                current++;
            }
            else
            {
                int temp = A[j];
                A[j] = A[current];
                A[current] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args)
    {
        int[] array = {0,1,2,2,2,0,0,1,0,1,2,2,1,1,2,1,0,1,2};
        sortColors(array);
        for(int i : array)
        {
            System.out.println(i);
        }
    }
}
