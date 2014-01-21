/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a binary tree containing digits from 0-9 only, 
 * each root-to-leaf path could represent a number.
 * @author chenbo
 */
public class SumRoottoLeafNumbers 
{
    static int sumNumbers(TreeNode root)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        if(root.left == null)
        {
            root.right.val += root.val * 10;
            return sumNumbers(root.right);
        }
        if(root.right == null)
        {
            root.left.val += root.val * 10;
            return sumNumbers(root.left);
        }
        root.right.val += root.val * 10;
        root.left.val += root.val * 10;
        return sumNumbers(root.left) + sumNumbers(root.right);
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(sumNumbers(root));
    }
}
