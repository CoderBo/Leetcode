/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a binary tree, flatten it to a linked list in-place.
 * @author chenbo
 */
public class FlattenBinaryTreetoLinkedList 
{
    static void flatten(TreeNode root)
    {
        if(root == null) return;   
        if(root.left == null && root.right == null) return;
        if(root.left == null) 
        {
            flatten(root.right);
            return;
        }
        TreeNode p = root.left;      
        while(p.right != null) p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
        flatten(root.right);
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
       /* root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);*/  
        flatten(root);
        System.out.println(root.left);
    }
}
