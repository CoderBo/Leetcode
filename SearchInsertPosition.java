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
    static int searchInsert(int[] A, int target) {
        return searchInsert(A, target, 0, A.length - 1);
    }
    static int searchInsert(int[] A, int target, int start, int end)
    {
        int middleIndex = (start + end) / 2;
        int middle = A[middleIndex];
        if(target == middle) return middleIndex;
        if(end <= start) return target < A[start]? start : start + 1;
        if(target < middle) return searchInsert(A, target, start, middleIndex - 1);
        else return searchInsert(A, target, middleIndex + 1, end);
    }
    
    static int searchInsert2(int[] A, int target) {
        int start = -1;
        int end = A.length;
        while(end - start > 1)
        {
            int mid = (end - start) / 2 + start;
            if(A[mid] >= target) end = mid;
            else start = mid;
        }
        return end;
    }
    public static void main(String[] args)
    {
        int[] array = {1, 3};
        System.out.println(searchInsert(array, 0));
    }
}
