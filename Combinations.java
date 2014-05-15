/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * problem:Given two integers n and k,
 * return all possible combinations of k numbers out of 1 ... n.
 * @author chenbo
 */
public class Combinations 
{
    static ArrayList<ArrayList<Integer>> combine(int n, int k)
    {
        return combine(n, k, new HashSet<ArrayList<Integer>>());
    }
    static ArrayList<ArrayList<Integer>> combine(int n, int k, HashSet<ArrayList<Integer>> set)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(k == 0) return result;
        if(k == 1)
        {
            for(int i = 1; i <= n; i++)
            {
                ArrayList<Integer> sub = new ArrayList<Integer>();
                sub.add(i);
                result.add(sub);
            }
            return result;
        }
        else
        {
            ArrayList<ArrayList<Integer>> temp = combine(n, k - 1, set);
            for(int i = 1; i <= n; i++)
            {
                for(ArrayList<Integer> t : temp)
                {
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    for(int j : t) a.add(j);
                    if(!t.contains(i)) 
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
    }
    static ArrayList<ArrayList<Integer>> combine2(int n, int k)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        setCombine(1, k, n, result, sub);
        return result;
    }
    static void setCombine(int start, int k,int n, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> sub)
    {
        if(sub.size() == k)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>(sub);
            result.add(temp);
        }
        else
        {
            for(int i = start; i <= n; i++)
            {
                sub.add(i);
                setCombine(i + 1, k, n, result, sub);
                sub.remove(sub.size() - 1);   
            }
        }
    }
    public static void main(String[] args)
    {
        System.out.println(combine2(4, 3));
    }
}
