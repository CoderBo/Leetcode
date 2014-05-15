/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * problem:Given a set of distinct integers, S, return all possible subsets.
 * @author chenbo
 */
public class Subsets 
{
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
    static ArrayList<ArrayList<Integer>> subsets(int[] S) 
    {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int max = 1 << S.length;
        for(int i = 0; i < max; i++)
        {
            ArrayList<Integer> subset = convert(S, i);
            result.add(subset);
        }
        return result;
    }
    
    static ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        if(S.length == 0) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        return subsets(S, S.length - 1);
    }
    static ArrayList<ArrayList<Integer>> subsets(int[] S, int index)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(index < 0)
        {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            result.add(sub);
            return result;
        }
        ArrayList<ArrayList<Integer>> pre = subsets(S, index - 1);
        result.addAll(pre);
        for(ArrayList<Integer> a : pre)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>(a);
            temp.add(S[index]);
            result.add(temp);
        }
        return result;
    }
     static ArrayList<ArrayList<Integer>> subsets3(int[] S)
     {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> sub = new ArrayList<Integer>();
         generate(0, S, result, sub);
         return result;
     }
     static void generate(int start, int[] S, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sub)
     {
         ArrayList<Integer> temp = (ArrayList<Integer>) sub.clone();
         result.add(temp);
         for(int i = start; i < S.length; i++)
         {
             sub.add(S[i]);
             generate(i + 1, S, result, sub);
             sub.remove(sub.size() - 1);
         }
     }
     
    
    public static void main(String[] arg)
    {
        int[] array = {1,2,3};
        ArrayList<ArrayList<Integer>> answer = subsets3(array);
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
