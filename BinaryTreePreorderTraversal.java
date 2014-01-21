/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * problem:Given a binary tree, 
 * return the preorder traversal of its nodes' values.
 * @author chenbo
 */
public class BinaryTreePreorderTraversal 
{
    static ArrayList<Integer> preorderTraversal(TreeNode root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || (!stack.isEmpty()))
        {
            while(p != null)
            {
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty())
            {
                p = stack.pop();
                p = p.right;
            }
        }
        return result;
        
    }
}
