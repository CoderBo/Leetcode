/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * problem:Given a binary tree, return the inorder traversal of its nodes' values.
 * @author chenbo
 */
public class BinaryTreeInorderTraversal 
{
    static ArrayList<Integer> inorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || (!stack.isEmpty()))
        {
            while(p != null)
            {
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty())
            {
                p = stack.peek();
                result.add(p.val);
                stack.pop();
                p = p.right;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(10);
        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(12);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(9);
        System.out.println(inorderTraversal(root));
    }
}
