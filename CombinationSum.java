/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

/**
 * problem:Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * @author chenbo
 */
public class CombinationSum
{
    static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        return combinationSum(candidates, target, 0, set);
    }
    static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target, int start, HashSet<ArrayList<Integer>> set)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates.length == 0 || target < candidates[0]) return result;
        for(int j = start; j < candidates.length; j++)
        {
            int i = candidates[j];
            if(i == target)
            {
                ArrayList<Integer> sub = new ArrayList<Integer>();
                sub.add(i);
                result.add(sub);
            }
            else
            {
                ArrayList<ArrayList<Integer>> temp = combinationSum(candidates, target - i, j,  set);
                for(ArrayList<Integer> a : temp)
                {
                    a.add(i);
                    Collections.sort(a);
                    if(!set.contains(a))
                    {
                        result.add(a);
                        set.add(a);
                    }
                }
            }
         }
        return result;
    }
    
    static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0, new HashSet<ArrayList<Integer>>());
    }
    static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target, int start, HashSet<ArrayList<Integer>> set)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(start >= candidates.length || target < candidates[start]) return result;
        for(int i = start; i < candidates.length; i++)
        {
            if(target == candidates[i])
            {
                ArrayList<Integer> sub = new ArrayList<Integer>();
                sub.add(candidates[i]);
                result.add(sub);
                return result;
            }
            else
            {
                ArrayList<ArrayList<Integer>> pre = combinationSum2(candidates, target - candidates[i], i, set);
                if(!pre.isEmpty())
                {
                    ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(pre);
                    for(ArrayList<Integer> a : temp)
                    {
                        a.add(0, candidates[i]);
                        {
                            if(!set.contains(a))
                            {
                                result.add(a);
                                set.add(a);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] condidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(condidates, 8));
    }
}
