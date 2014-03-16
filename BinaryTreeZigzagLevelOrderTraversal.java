/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * problem:
 * @author chenbo
 */
public class BinaryTreeZigzagLevelOrderTraversal 
{
    static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        int currentLayer = 1;
        Queue<TreeNode> upLevel = new LinkedList<TreeNode>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        result.add(temp);
        upLevel.offer(root);
        while(!upLevel.isEmpty())
        {
            currentLayer++;
            Queue<TreeNode> downLevel = new LinkedList<TreeNode>();
            ArrayList<Integer> sub = new ArrayList<Integer>();
            while(!upLevel.isEmpty())
            {
                TreeNode current = upLevel.poll();
                if(current.left != null)
                {
                    downLevel.offer(current.left);
                    sub.add(current.left.val);
                }
                if(current.right != null)
                {
                    downLevel.offer(current.right);
                    sub.add(current.right.val);
                }
            }
            if(currentLayer % 2 == 0) Collections.reverse(sub);
            if(!sub.isEmpty()) result.add(sub);
            upLevel = downLevel;
        }
        return result;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);       
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5); 
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println(zigzagLevelOrder(root));
    }
}
