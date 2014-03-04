/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Populate each next pointer to point to its next right node. If there is no next right node, 
 * the next pointer should be set to NULL.
 * @author chenbo
 */
class TreeLinkNode 
{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
public class PopulatingNextRightPointersinEachNode 
{
    public void connect(TreeLinkNode root)
    {
        if(root == null || root.left == null) return;
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
