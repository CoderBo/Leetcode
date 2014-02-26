/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * problem:Given a binary tree, return the postorder traversal of its nodes' values.
 * @author chenbo
 */
public class BinaryTreePostorderTraversal 
{
    static ArrayList<Integer> postorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current;
        TreeNode pre = null;
        stack.push(root);
        while(!stack.isEmpty())
        {
            current = stack.peek();
            if((current.left == null && current.right == null)
                    || (pre != null && (pre == current.left || pre == current.right)))
            {
                result.add(current.val);
                pre = current;
                stack.pop();
            }
            else
            {
                if(current.right != null) stack.push(current.right);
                if(current.left != null) stack.push(current.left);
            }
        }
        return result;
    }
    static ArrayList<Integer> postorderTraversal2(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        while(p != null || (!stack.isEmpty()))
        {
            while(p != null)
            {
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty())
            {
                p = stack.pop();
                if(!set.contains(p))
                {
                    set.add(p);
                    stack.push(p);
                    p = p.right;
                            
                }
                else
                {
                    result.add(p.val);
                    p = null;
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        System.out.println(postorderTraversal2(head));
    }
}
