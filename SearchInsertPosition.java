package leetcode;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * problem:Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * @author chenbo
 */
public class SearchInsertPosition 
{
    static int searchInsert(int[] A, int target)
    {
        for(int i = 0; i < A.length; i++)
        {
            if(target <= A[i]) return i;
        }
        return A.length;
    }
    public static void main(String[] args)
    {
        int[] array = {1};
        System.out.println(searchInsert(array, 0));
    }
}
