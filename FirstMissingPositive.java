/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * problem:Given an unsorted integer array, find the first missing positive integer.
 * @author chenbo
 */
public class FirstMissingPositive 
{
    static void deletRepeat(int []array)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) 
        {
            if (!list.contains(array[i]))  
                list.add(array[i]);
        }
        int j = 0;
        for(int i : list)
        {
            array[j++] = i;
        }
    }
    
    
    static int firstMissingPositive(int[] A)
    {
        if(A.length == 0) return 1;
        if(A.length == 1 && A[0] == 0) return 1;
        Arrays.sort(A);
        deletRepeat(A);
        int i = 0;
        while(A[i] <= 0) i++;
        int j = 1;
        while(i < A.length)
        {
            if(i < A.length - 1 && A[i] == A[i + 1]) i++;
            if(A[i] != j) return j;
            else
            {
                i++;
                j++;
            }
        }
        return j;
    }
    
    public static void main(String[] args)
    {
        int []array = {1,1,1,1,1};
        System.out.println(firstMissingPositive(array));
    }
}
