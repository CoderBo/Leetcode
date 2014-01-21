/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;
import java.util.ArrayList;
/**
 * problem:Given a collection of numbers, return all possible permutations.
 * @author chenbo
 */
public class Permutations 
{
    static ArrayList<Integer> charAt(int first, int n, ArrayList<Integer> item)
    {
        item.add(n, first);
        return item;
    }
    static ArrayList<ArrayList<Integer>> permute(int[] num)
    {
        if(num == null) return null;
        ArrayList<ArrayList<Integer>> permutation = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0)
        {          
            permutation.add(new ArrayList<Integer>());
            return permutation;
        }
        int first = num[0];
        int[] remain = new int[num.length - 1];
        for(int i = 1; i < num.length; i++)
        {
            remain[i - 1] = num[i];
        }
        ArrayList<ArrayList<Integer>> array = permute(remain);
        for(ArrayList<Integer> item : array)
        {
            for(int i = 0; i <= item.size(); i++)
            {
                ArrayList<Integer> newItem = new ArrayList<Integer>();
                for(Integer x : item)
                {
                    newItem.add(x);
                }
                ArrayList<Integer> newArray = charAt(first, i, newItem);
                permutation.add(newArray);
            }
        }
        return permutation;
    }
    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5,6,7,8};
        System.out.println(permute(array));
    }
}
