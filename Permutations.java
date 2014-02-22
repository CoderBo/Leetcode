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
    public static void main(String[] args)
    {
        int[] array = {1,2,3,4,5,6,7,8};
        System.out.println(permute(array));
    }
}
