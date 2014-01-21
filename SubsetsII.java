/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;
import java.util.*;
import static leetcode.Subsets.subsets;
/**
 * problem:Given a collection of integers that might contain duplicates,
 * S, return all possible subsets.
 * @author chenbo
 */
public class SubsetsII 
{
    static void removeDuplicate(ArrayList<ArrayList<Integer>> list)  
    {  
        HashSet h = new HashSet(list);
        list.clear();  
        list.addAll(h);
    }
    static ArrayList<Integer> convert(int[] array, int k)
    {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for(int i = k; i > 0; i >>= 1)
        {
            if((i & 1) == 1) subset.add(array[index]);
            index++;
        }
        return subset;
    }
    static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num)
    {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int max = 1 << num.length;
        for(int i = 0 ;i < max; i++)
        {
            ArrayList<Integer> subset = convert(num, i);
            result.add(subset);
        }
        removeDuplicate(result);
        return result;
    }
    public static void main(String[] arg)
    {
        int[] array = {1,1};
        ArrayList<ArrayList<Integer>> answer = subsetsWithDup(array);
        System.out.println(answer.size());
        for(ArrayList<Integer> a : answer)
        {
            for(int i : a)
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
