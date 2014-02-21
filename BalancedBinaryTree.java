/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a binary tree, determine if it is height-balanced.
 * @author chenbo
 */

class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; } 
}
public class BalancedBinaryTree 
{
    static int getHeight(TreeNode root)
    {
        if(root == null) return 0;
        else return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    static boolean isBalanced(TreeNode root)
    {
        if(root == null) return true;
        else if(root.left == null && root.right == null) return true;
        else
        {
            int lheight = getHeight(root.left);
            int rheight = getHeight(root.right);
            if(Math.abs(rheight - lheight) > 1) return false;
            else return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    static boolean isBalanced2(TreeNode root)
    {
        if(root == null) return true;
        return isBalanced(root, new int[1]);
    }
    static boolean isBalanced(TreeNode root, int[] height)
    {
        if(root == null)
        {
            height[0] = 0;
            return true;
        }
        int[] leftHeight = new int[1];
        int[] rightHeight = new int[1];
        boolean leftIsBalanced = isBalanced(root.left, leftHeight);
        boolean rightIsBalanced = isBalanced(root.right, rightHeight);
        if(leftIsBalanced && rightIsBalanced && Math.abs(leftHeight[0] - rightHeight[0]) <= 1)
        {
            height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;
            return true;
        }
        else
        {
            height[0] = Math.max(leftHeight[0], rightHeight[0]) + 1;
            return false;
        }
    }
    public static void main(String[] args)
    {
        TreeNode root  = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.left.right = new TreeNode(1);
        System.out.println(isBalanced2(root));
    }
}
