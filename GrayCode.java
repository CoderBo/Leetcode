/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.*;
/**
 * problem:Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * @author chenbo
 */
public class GrayCode 
{
    static ArrayList<Integer> grayCode(int n)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n == 0)
        {
            result.add(0);
            return result;
        }
        if(n == 1)
        {
            result.add(0);
            result.add(1);
            return result;
        }
        ArrayList<Integer> sub = grayCode(n - 1);
        result.addAll(sub);
        for(int i = sub.size() - 1; i >= 0; i--)
            result.add(sub.get(i) | 1 << (n - 1));
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(grayCode(3));
    }
}
