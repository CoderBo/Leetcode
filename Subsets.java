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
    
    public ArrayList<ArrayList<Integer>> subsets2(int[] S) {
        if(S.length == 0) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(S);
        return subsets(S, S.length - 1);
    }
    public ArrayList<ArrayList<Integer>> subsets(int[] S, int index)
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
    public static void main(String[] arg)
    {
        int[] array = {1,1};
        ArrayList<ArrayList<Integer>> answer = subsets(array);
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
