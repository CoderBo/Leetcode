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
    public void connect(TreeLinkNode root) {
        connect(root, null);
    }
    public void connect(TreeLinkNode root, TreeLinkNode neighbour)
    {
        if(root == null || root.left == null) return;
        root.left.next = root.right;
        if(neighbour != null) root.right.next = neighbour.left;
        connect(root.left, root.left.next);
        connect(root.right, root.right.next);
    }
}
