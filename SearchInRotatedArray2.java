/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:
 * @author chenbo
 */
public class SearchInRotatedArray2 
{
    static boolean search(int[] A, int target)
    {
        return search2(A, target, 0, A.length - 1);
    }
    
    static boolean search2(int[] array, int target, int left, int right)
    {
        int mid = (left + right) / 2;
        if(array[mid] == target) return true;
        if(left > right) return false;
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
        else if(array[mid] < array[left])
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
                boolean result = search2(array, target, left, mid - 1);
                if(result == false)
                {
                    return search2(array, target, mid + 1, right);
                }
                else
                {
                    return result;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        int[] array = {3,1,1};
        System.out.println(search(array, -3));
    }
}

