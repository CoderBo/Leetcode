/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

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
    static int numTrees(int a, int b)
    {
        if(a > b) return 0;
        if(a == b) return 1;
        int result = 0;
        for(int i = a; i <= b; i++)
        {
            int left = numTrees(a, i - 1);
            int right = numTrees(i + 1, b);
            if(left == 0) result += right;
            else if(right == 0) result += left;
            else result = result + left * right;
        }
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(numTrees(3));
    }
}