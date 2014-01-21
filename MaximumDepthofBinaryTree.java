/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a binary tree, find its maximum depth.
 * @author chenbo
 */
public class MaximumDepthofBinaryTree 
{   
    static int maxDepth(TreeNode root)
    {
        if(root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
       // root.left.left = new TreeNode(1);
        
        System.out.println(maxDepth(root));
    }
}
