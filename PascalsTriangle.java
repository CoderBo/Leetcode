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
    public static void main(String[] args)
    {
        System.out.println(generate(5));
    }
}
