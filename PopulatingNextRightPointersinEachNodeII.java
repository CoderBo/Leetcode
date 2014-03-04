/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * @author chenbo
 */
public class PopulatingNextRightPointersinEachNodeII 
{
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root == null) return;
        ArrayList<TreeLinkNode> array = new ArrayList<TreeLinkNode>();
        array.add(root);
        while(!array.isEmpty())
        {
            ArrayList<TreeLinkNode> temp = new ArrayList<TreeLinkNode>();
            for(TreeLinkNode i : array)
            {   
                if(i.left != null)
                {
                    temp.add(i.left);
                }
                if(i.right != null)
                {
                    temp.add(i.right);
                }
            }
            if(temp.size() != 0)
            {
                for(int i = 0; i < temp.size() - 1; i++)
                {
                    temp.get(i).next = temp.get(i + 1);
                }
                temp.get(temp.size() - 1).next = null;
            }
            array = temp;
        }
    }
    public void connect2(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        TreeLinkNode p = root.next;
        while(p != null)
        {
            if(p.left != null)
            {
                p = p.left;
                break;
            }
            if(p.right != null)
            {
                p = p.right;
                break;
            }
            p = p.next;
        }
        if(root.right == null)
        {
            root.left.next = p;
        }
        else if(root.left == null)
        {
            root.right.next = p;
        }
        else
        {
            root.left.next = root.right;
            root.right.next = p;
        }
        connect2(root.right);
        connect2(root.left);
    }
}
