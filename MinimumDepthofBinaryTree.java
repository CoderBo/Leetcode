/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a binary tree, find its minimum depth.
 * @author chenbo
 */
public class MinimumDepthofBinaryTree 
{
    static int minDepth(TreeNode root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        else if(root.left == null) return minDepth(root.right) + 1;
        else if(root.right == null) return minDepth(root.left) + 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
      //  root.left.left = new TreeNode(1);
      //  root.left.left.left = new TreeNode(1);
      //  root.right = new TreeNode(2);
        
        System.out.println(minDepth(root));
    }
   
}
