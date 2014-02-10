/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.HashSet;

/**
 * problem:Given n, how many structurally unique 
 * BST's (binary search trees) that store values 1...n?
 * @author chenbo
 */
public class UniqueBinarySearchTrees 
{
    static int numTrees(int n)
    {
        return numTrees(1, n);
    }
    static int numTrees(int start, int end)
    {
        if(start == end) return 1;
        if(start > end) return 0;
        int result = 0;
        for(int i = start; i <= end; i++)
        {
            int left = numTrees(start, i - 1);
            int right = numTrees(i + 1, end);
            if(left == 0) result += right;
            else if(right == 0) result += left;
            else result += left * right;
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(numTrees(3));
    }
}
