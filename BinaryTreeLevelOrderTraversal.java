/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * problem:Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * @author chenbo
 */
public class BinaryTreeLevelOrderTraversal 
{
    static void printQ(Queue<TreeNode> q)
    {
        for(TreeNode i : q)
        {
            System.out.print(i.val);
            System.out.print(" ");
        }
        System.out.println("");
    }
    static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root)
    {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();    
        queue.offer(p); 
        ArrayList<TreeNode> head = new ArrayList<TreeNode>();
        head.add(p);
        result.add(head);
        while(!queue.isEmpty())
        {
            ArrayList<TreeNode> sub = new ArrayList<TreeNode>();
            p = queue.poll();
            for(TreeNode i: result.get(result.size() - 1))
            {
                if(i.left != null) sub.add(i.left);
                if(i.right != null) sub.add(i.right);
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
    static ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> upLevel = new LinkedList<TreeNode>();
        upLevel.offer(root);
        while(!upLevel.isEmpty())
        {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            Queue<TreeNode> downLevel = new LinkedList<TreeNode>();
            while(!upLevel.isEmpty())
            {
                TreeNode temp = upLevel.poll();
                sub.add(temp.val);
                if(temp.left != null) downLevel.offer(temp.left);
                if(temp.right != null) downLevel.offer(temp.right);
            }
            result.add(sub);
            upLevel = downLevel;
        }
        return result;
    }
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);       
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);      
        System.out.println(levelOrder2(root));
    }
}
