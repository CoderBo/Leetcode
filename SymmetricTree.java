/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * problem:Given a binary tree,
 * check whether it is a mirror of itself (ie, symmetric around its center).
 * @author chenbo
 */
public class SymmetricTree 
{
    static boolean checkPalindrome(ArrayList<Integer> item)
    {
        ArrayList<Integer> temp = new ArrayList<Integer>(item);
        Collections.reverse(temp);
        return item.toString().equals(temp.toString());
    }
    static boolean isSymmetric(TreeNode root)
    {
        if(root == null) return true;
        ArrayList<TreeNode> array = new ArrayList<TreeNode>();
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
                else sub.add(Integer.MAX_VALUE);
                if(i.right != null)
                {
                    sub.add(i.right.val);
                    temp.add(i.right);
                }
                else sub.add(Integer.MAX_VALUE);
            }
            if(sub.size() != 0)
            {
                if(sub.size() % 2 != 0) return false;
                if(!checkPalindrome(sub)) return false;
            }
            array = temp;
        }
         return true;
    }
    
    static boolean isSymmetric2(TreeNode root) {
        if(root == null) return true;
        else return isSymmetric(root.left, root.right);
    }
    static boolean isSymmetric(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 == null) return false;
        if(root2 != null && root1 == null) return false;
        if(root1.val != root2.val) return false;
        else return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(isSymmetric2(root));
    }
}
