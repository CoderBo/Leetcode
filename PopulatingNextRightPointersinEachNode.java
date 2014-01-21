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
    static void connect(TreeLinkNode root)
    {
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
}
