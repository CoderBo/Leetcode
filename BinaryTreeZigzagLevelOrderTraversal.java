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
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(p);
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<TreeNode> head = new ArrayList<TreeNode>();
        head.add(p);
        result.add(head);
        boolean inorder = false;
        while(!queue.isEmpty())
        {
            System.out.println(inorder);
            ArrayList<TreeNode> sub = new ArrayList<TreeNode>();
            p = queue.poll();
            if(inorder == true)
            {
                ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
                for(TreeNode i : result.get(result.size() - 1)) temp.add(i);
                Collections.reverse(temp);
                for(TreeNode i: temp)
                {
                    if(i.left != null) sub.add(i.left);
                    if(i.right != null) sub.add(i.right);
                }
                inorder = false;
            }
            else
            {
                for(TreeNode i : result.get(result.size() - 1))
                {
                    if(i.left != null) sub.add(i.left);
                    if(i.right != null) sub.add(i.right);
                }
                Collections.reverse(sub);
                inorder = true;
            }
            result.add(sub);
            if(p.left != null)
            {
                queue.offer(p.left);
            }
            if(p.right != null)
            {
                queue.offer(p.right);
            }
            if(!result.contains(sub)) result.add(sub);
        }
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<TreeNode> t : result)
        {
            ArrayList<Integer> subT = new ArrayList<Integer>();
            for(TreeNode node : t)
            {
                subT.add(node.val);
            }
            if(!subT.isEmpty() ) answer.add(subT);
        }
        return answer;
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
