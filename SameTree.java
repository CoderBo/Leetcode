/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given two binary trees, write a function to check if they are equal or not.
 * @author chenbo
 */
public class SameTree 
{
    static boolean isSameTree(TreeNode p, TreeNode q)
    {
        if(p == null && q == null) return true;
        if(p == null && q != null || p != null && q == null) return false;
        if(p.val != q.val) return false;
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public static void main(String[] args)
    {
        TreeNode p = new TreeNode(5);
        p.left = new TreeNode(4);
        p.right = new TreeNode(3);
        p.right.right = new TreeNode(2);
        p.right.right.left = new TreeNode(1);
        
        TreeNode q = new TreeNode(5);
        q.left = new TreeNode(4);
        q.right = new TreeNode(3);
        q.right.right = new TreeNode(2);
       // q.right.right.left = new TreeNode(1);
        
        System.out.println(isSameTree(p, q));
    }
}
