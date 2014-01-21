/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Hashtable;

/**
 * problem:Given pre order and in order traversal of a tree,
 * construct the binary tree.
 * @author chenbo
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal 
{
    static TreeNode buildTree(int[] preorder, int[] inorder)
    {
        Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) table.put(inorder[i], i);
        return buildTree(table, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    static TreeNode buildTree(Hashtable<Integer, Integer> table, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd)
    {
        if(preStart > preEnd || inStart > inEnd) return null;
        int temp = preorder[preStart];
        TreeNode root = new TreeNode(temp);
        int middleIndex = table.get(temp);
        int leftInStart = inStart;
        int leftInEnd = middleIndex - 1;
        int rightInStart = middleIndex + 1;
        int rightInEnd = inEnd;
        
        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + leftInEnd - leftInStart;
        int rightPreStart = leftPreEnd + 1;
        int rightPreEnd = preEnd;
        root.left = buildTree(table, preorder, inorder, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
        root.right = buildTree(table, preorder, inorder, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
        return root;
    }
    public static void main(String[] args)
    {
        int[] preorder = {1,2,4,5,3,7};
        int[] order = {4,2,5,1,3,7};
        TreeNode root = buildTree(preorder, order);
        System.out.println(root.left.right.val);
    }
}
