/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Given n, generate all structurally unique 
 * BST's (binary search trees) that store values 1...n.
 * @author chenbo
 */
public class UniqueBinarySearchTreesII 
{
    static ArrayList<TreeNode> generateTrees(int n)
    {
        return generateTrees(1, n);
    }
    static ArrayList<TreeNode> generateTrees(int a, int b)
    {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(a > b) result.add(null);
        if(a == b) result.add(new TreeNode(a));
        if(a < b)
        {
            for(int i = a; i <= b; i++)
            {
                ArrayList<TreeNode> left = generateTrees(a, i - 1);
                ArrayList<TreeNode> right = generateTrees(i + 1, b);
                for(TreeNode m : left)
                {
                    for(TreeNode n : right)
                    {
                        TreeNode head = new TreeNode(i);
                        head.left = m;
                        head.right = n;
                        result.add(head);
                    }
                }
            }
        }
        return result;
    }
}
