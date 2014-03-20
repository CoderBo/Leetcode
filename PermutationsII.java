/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import static leetcode.Permutations.permute;

/**
 * problem:Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * @author chenbo
 */
public class PermutationsII 
{
    static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        return permuteUnique(num, 0, new HashSet<ArrayList<Integer>>());
    }
    static ArrayList<ArrayList<Integer>> permuteUnique(int[] num, int start, HashSet<ArrayList<Integer>> set)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(start == num.length - 1)
        {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            sub.add(num[start]);
            result.add(sub);
            return result;
        }
        ArrayList<ArrayList<Integer>> pre = permuteUnique(num, start + 1, set);
        for(ArrayList<Integer> a : pre)
        {
            for(int i = 0; i <= a.size(); i++)
            {
                ArrayList<Integer> sub = new ArrayList<Integer>(a);
                sub.add(i, num[start]);
                if(!sub.isEmpty() && !set.contains(sub))
                {
                    result.add(sub);
                    set.add(sub);
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] array = {1,1,3};
        System.out.println(permuteUnique(array));
    }
}
