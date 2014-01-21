/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a sorted array of integers, 
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * @author chenbo
 */
public class SearchforaRange 
{
    static int[] searchRange(int[] A, int target)
    {
        int first = getFirst(A, target, 0, A.length - 1);
        int last = getLast(A, target, 0, A.length - 1);
        int [] result = {first, last};
        return result;
    }
    static int getFirst(int[] A, int target, int start, int end)
    {
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(target > A[mid]) return getFirst(A, target, mid + 1, end);
        if(target < A[mid]) return getFirst(A, target, start, mid - 1);
        else if(mid == 0 || A[mid] != A[mid - 1]) return mid;
        else return getFirst(A, target, start, mid - 1);
    }
    static int getLast(int[] A, int target, int start, int end)
    {
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(target > A[mid]) return getLast(A, target, mid + 1, end);
        if(target < A[mid]) return getLast(A, target, start, mid - 1);
        else if(mid == A.length - 1 || A[mid] != A[mid + 1]) return mid;
        else return getLast(A, target, mid + 1, end);
    }
    public static void main(String[] args)
    {
        int[] array = {1,1,5,7,7,7,8,8,8,10};
        System.out.println(searchRange(array, 8)[0] + " " + searchRange(array, 8)[1]);
    }
}
