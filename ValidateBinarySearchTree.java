/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Given a binary tree, determine if it is a valid binary search tree (BST).
 * @author chenbo
 */
public class ValidateBinarySearchTree 
{
    static void copyBST(TreeNode root, ArrayList<Integer> array)
    {
        if(root == null) return;
        copyBST(root.left, array);
        array.add(root.val);
        copyBST(root.right, array);
    }
    
    static boolean isValidBST(TreeNode root)
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        copyBST(root, array);
        for(int i = 1; i < array.size(); i++)
        {
            if(array.get(i) <= array.get(i - 1)) return false;
        }
        return true;
    }
    
    static boolean isValidBST2(TreeNode root) {
        int[] flag = new int[1];
        flag[0] = Integer.MIN_VALUE;
        return isValid(root, flag);
    }
    static boolean isValid(TreeNode root, int[] flag)
    {
        if(root == null) return true;
        if(isValid(root.left, flag) == false) return false;
        if(root.val <= flag[0]) return false;
        flag[0] = root.val;
        if(isValid(root.right, flag) == false) return false;
        return true;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left = new TreeNode(1);
        
        System.out.println(isValidBST(root));
    }
}
