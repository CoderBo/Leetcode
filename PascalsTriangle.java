/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Given numRows, generate the first numRows of Pascal's triangle.
 * @author chenbo
 */
public class PascalsTriangle 
{
    static ArrayList<ArrayList<Integer>> generate(int numRows)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0) return result;
        if(numRows == 1)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            result.add(temp);
            return result;
        }
        else
        {
            result = generate(numRows - 1);
            ArrayList<Integer> last = result.get(result.size() - 1);
            ArrayList<Integer> sub = new ArrayList<Integer>();
            sub.add(1);
            for(int i = 0; i < last.size() - 1; i++)
                sub.add(last.get(i) + last.get(i + 1));
            sub.add(1);
            result.add(sub);
            return result;
        }
    }
    
    public static ArrayList<ArrayList<Integer>> generate2(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sub = new ArrayList<Integer>();
        sub.add(1);
        result.add(sub);
        for(int i = 1; i < numRows; i++)
        {
            ArrayList<Integer> sub2 = new ArrayList<Integer>();
            sub2.add(1);
            for(int j = 1; j < i; j++)
            {
                sub2.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }
            sub2.add(1);
            result.add(sub2);
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(generate2(5));
    }
}
