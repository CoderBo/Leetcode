/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:
 * @author chenbo
 */
public class SearchInRotatedArray 
{
    static int search(int[] A, int target)
    {
        return search2(A, target, 0, A.length - 1);
    }
    static int search2(int[] array, int target, int left, int right)
    {
        int mid = (left + right) / 2;
        if(array[mid] == target) return mid;
        if(left > right) return -1;
        if(array[left] < array[mid])
        {
            if(target >= array[left] && target <= array[mid])
            {
                return search2(array, target, left, mid - 1);
            }
            else
            {
                return search2(array, target, mid + 1, right);
            }
        }
        else if(array[mid] < array[right])
        {
            if(target >= array[mid] && target <= array[right])
            {
                return search2(array, target, mid + 1, right);
            }
            else
            {
                return search2(array, target, left, mid - 1);
            }
        }
        else if(array[left] == array[mid])
        {
            if(array[mid] != array[right])
            {
                return search2(array, target, mid + 1, right);
            }
            else
            {
                int result = search2(array, target, left, mid - 1);
                if(result == -1)
                {
                    return search2(array, target, mid + 1, right);
                }
                else
                {
                    return result;
                }
            }
        }
        return -1;
    }
    
    
    static int search3(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(end - start > 1)
        {
            int mid = (end + start) / 2;
            if(A[mid] < A[end]) end = mid;
            else start = mid;
        }
        return end;
    }
    
    public static void main(String[] args)
    {
        int[] array = {4, 5, 6, 7, 8, 1, 2};
        System.out.println(search3(array, 1));
    }
}
