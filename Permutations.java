    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/**
 * problem:Given a collection of numbers, return all possible permutations.
 * @author chenbo
 */
public class Permutations 
{
    static ArrayList<ArrayList<Integer>> permute(int []num)
    {
        if(num.length == 0) return new ArrayList<ArrayList<Integer>>();
        else return permute(num, num.length - 1);
    }
    static ArrayList<ArrayList<Integer>> permute(int []num, int n)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n == 0)
        {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            sub.add(num[0]);
            result.add(sub);
            return result;
        }
        ArrayList<ArrayList<Integer>> previous = permute(num, n - 1);
        int item = num[n];
        for(ArrayList<Integer> a : previous)
        {
            for(int i = 0; i <= a.size(); i++)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(a.subList(0, i));
                temp.add(item);
                temp.addAll(a.subList(i, a.size()));
                result.add(temp);
            }
            
        }
        return result;
    }
    
    static ArrayList<ArrayList<Integer>> permute2(int[] num) {
        return permute2(num, 0, new HashSet<ArrayList<Integer>>());
    }
    
    static ArrayList<ArrayList<Integer>> permute2(int[] num, int start, HashSet<ArrayList<Integer>> set)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(start == num.length - 1)
        {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            sub.add(num[start]);
            result.add(sub);
            return result;
        }
        ArrayList<ArrayList<Integer>> pre = permute2(num, start + 1, set);
        for(ArrayList<Integer> a : pre)
        {
            for(int i = 0; i <= a.size(); i++)
            {
                ArrayList<Integer> temp = (ArrayList<Integer>)a.clone();
                temp.add(i, num[start]);
                if(temp.size() < num.length)
                {
                    result.add(temp);
                }
                else if(!set.contains(temp))
                {
                    result.add(temp);
                    set.add(temp);
                }           
            }
        }
        System.out.println(set.size());
        return result;
    }
    
    
    
    public static void main(String[] args)
    {
        int[] array = {0,0,1};
        System.out.println(permute2(array));
    }
}
