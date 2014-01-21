/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:
 * @author chenbo
 */
public class NextPermutation 
{
    static void swap(int[] num, int i, int j)
    {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
            
    static void reverse(int[] num, int start, int end)
    {
        int i = start;
        int j = end;
        while(i < j)
        {
            swap(num, i, j);
            i++;
            j--;
        }
    }
    static void nextPermutation(int[] num)
    {
        if(num.length <= 1) return;
        int i = num.length - 2;
        while(i >= 0 && num[i] >= num[i + 1]) i--;
        if(i < 0)
        {
            reverse(num, 0, num.length - 1);
            return;
        }
        int j = num.length - 1;
        while(num[i] >= num[j]) j--;
        swap(num, i, j);
        reverse(num, i + 1, num.length - 1);
    }
    public static void main(String[] args)
    {
        int[] array = {5,4,3,2,1};
        nextPermutation(array);
        for(int i : array)
        {
            System.out.println(i);
        }
    }
}
