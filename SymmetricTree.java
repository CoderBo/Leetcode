/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * problem:Given a binary tree,
 * check whether it is a mirror of itself (ie, symmetric around its center).
 * @author chenbo
 */
public class SymmetricTree 
{
    static boolean checkPalindrome(ArrayList<Integer> item)
    {
        ArrayList<Integer> temp = new ArrayList<Integer>(item);
        Collections.reverse(temp);
        return item.toString().equals(temp.toString());
    }
    static boolean isSymmetric(TreeNode root)
    {
        if(root == null) return true;
        ArrayList<TreeNode> array = new ArrayList<TreeNode>();
        array.add(root);
        while(!array.isEmpty())
        {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            for(TreeNode i : array)
            {   
                if(i.left != null)
                {
                    sub.add(i.left.val);
                    temp.add(i.left);
                }
                else sub.add(Integer.MAX_VALUE);
                if(i.right != null)
                {
                    sub.add(i.right.val);
                    temp.add(i.right);
                }
                else sub.add(Integer.MAX_VALUE);
            }
            if(sub.size() != 0)
            {
                if(sub.size() % 2 != 0) return false;
                if(!checkPalindrome(sub)) return false;
            }
            array = temp;
        }
         return true;
    }
}
