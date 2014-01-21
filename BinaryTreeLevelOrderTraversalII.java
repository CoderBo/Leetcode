/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * problem:Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * @author chenbo
 */
public class BinaryTreeLevelOrderTraversalII 
{
    static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<TreeNode> array = new ArrayList<TreeNode>();
        ArrayList<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(root.val);
        result.add(firstRow);
        array.add(root);
        while(!array.isEmpty())
        {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            for(TreeNode i : array)
            {   
                if(i.left != null)
                {
                    sub.add(i.left.val);
                    temp.add(i.left);
                }
                if(i.right != null)
                {
                    sub.add(i.right.val);
                    temp.add(i.right);
                }   
            }
            if(sub.size() != 0) result.add(sub);
            array = temp;
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(-8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(-8);
        root.left.left.left = new TreeNode(-1);
        System.out.println(levelOrderBottom(root));
    }
   
}
