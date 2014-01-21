/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * @author chenbo
 */
public class PascalsTriangleII 
{
    static ArrayList<Integer> getRow(int rowIndex)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(rowIndex < 0) return result;
        if(rowIndex == 1)
        {
            result.add(1);
            return result;
        }
        else
        {
            ArrayList<Integer> pre = getRow(rowIndex - 1);
            result.add(1);
            for(int i = 0; i < pre.size() - 1; i++)
                result.add(pre.get(i) + pre.get(i + 1));
            result.add(1);
            return result;
        }
    }
    public static void main(String[] args)
    {
        System.out.println(getRow(10));
    }
}