/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * @author chenbo
 */
public class BinaryTreeMaximumPathSum 
{
    static int maxPathSum(TreeNode root)
    {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }
    static int maxPathSum(TreeNode root, int[] max)
    {
        if(root == null) return 0;
        int lMax = maxPathSum(root.left, max);
        int rMax = maxPathSum(root.right, max);
        int cMax = Math.max(root.val, Math.max(root.val + lMax, root.val + rMax));
        max[0] = Math.max(max[0], Math.max(cMax, root.val + lMax + rMax));
        return cMax;
    }
}
