/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Hashtable;

/**
 * problem:Given in order and post order traversal of a tree, construct the binary tree.
 * @author chenbo
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal 
{
    static TreeNode buildTree(int[] inorder, int[] postorder)
    {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) table.put(inorder[i], i);
        return buildTree(table, postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
    static TreeNode buildTree(Hashtable<Integer, Integer> table, int[] preorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd)
    {
        if(postStart > postEnd || inStart > inEnd) return null;
        int temp = preorder[postEnd];
        TreeNode root = new TreeNode(temp);
        int middleIndex = table.get(temp);
        int leftInStart = inStart;
        int leftInEnd = middleIndex - 1;
        int rightInStart = middleIndex + 1;
        int rightInEnd = inEnd;
        
        int leftPostStart = postStart;
        int leftPostEnd = leftPostStart + leftInEnd - leftInStart;
        int rightPostStart = leftPostEnd + 1;
        int rightPostEnd = postEnd - 1;
        root.left = buildTree(table, preorder, inorder, leftPostStart, leftPostEnd, leftInStart, leftInEnd);
        root.right = buildTree(table, preorder, inorder, rightPostStart, rightPostEnd, rightInStart, rightInEnd);
        return root;
    }
    public static void main(String[] args)
    {
        int[] inoder = {4,2,5,1,3,7};
        int[] postorder = {4,5,2,7,3,1};
        TreeNode root = buildTree(inoder, postorder);
        System.out.println(root.left.right.val);
    }
}
