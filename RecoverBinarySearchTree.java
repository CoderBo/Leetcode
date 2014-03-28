/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * @author chenbo
 */
public class RecoverBinarySearchTree 
{
    static void recoverTree(TreeNode root)
    {
        TreeNode[] pre = new TreeNode[1];
        TreeNode[] first = new TreeNode[1];
        TreeNode[] second = new TreeNode[1];
        recoverTree(root, pre, first, second);
        test(first);
        System.out.println(first[0].val);
        int temp = first[0].val;
        first[0].val = second[0].val;
        second[0].val = temp;
    }
    static void recoverTree(TreeNode root, TreeNode[] pre, TreeNode[] first, TreeNode[] second)
    {
        if(root == null) return;
        recoverTree(root.left, pre, first, second);
        if(pre[0] != null && pre[0].val > root.val)
        {
            if(first[0] == null)
            {
                first[0] = pre[0];
                second[0] = root;
            }
            else second[0] = root;
        }
        pre[0] = root;
        recoverTree(root.right, pre, first, second);
    }
    static void test(TreeNode[] first)
    {
        TreeNode temp = new TreeNode(2);
        first[0] = temp;
    }
    static void change(TreeNode root)
    {
        root = new TreeNode(1);
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(13);
        TreeNode a = new TreeNode(0);
        change(a);
        System.out.println(a.val);
    }
}
