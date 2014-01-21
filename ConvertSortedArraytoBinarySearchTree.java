/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * @author chenbo
 */
public class ConvertSortedArraytoBinarySearchTree 
{
    static TreeNode sortedArrayToBST(int[] num)
    {
        return sortedArrayToBST(num, 0, num.length - 1);
    }
    static TreeNode sortedArrayToBST(int[] num, int start, int end) 
    {
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, start, mid - 1);
        node.right = sortedArrayToBST(num, mid + 1, end);
        return node;
    }
}
