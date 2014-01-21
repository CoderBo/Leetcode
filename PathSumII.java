/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;
import java.util.ArrayList;

/**
 * problem:Given a binary tree and a sum, find all 
 * root-to-leaf paths where each path's sum equals the given sum.
 * @author chenbo
 */
public class PathSumII 
{   
    static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum)
    {
        ArrayList<ArrayList<Integer>> set = new ArrayList<ArrayList<Integer>>();
        findPathSum(root, set, sum, new ArrayList<Integer>());
        return set;
    }
    static void findPathSum(TreeNode root, ArrayList<ArrayList<Integer>> set, int sum, ArrayList<Integer> path)
    {
        
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null)
        {
            if(sum == root.val)
            {
                ArrayList<Integer> duplicate = new ArrayList<Integer>(path);
                set.add(duplicate);
            }
        }
        else
        {
            findPathSum(root.left, set, sum - root.val, path);
            findPathSum(root.right, set, sum - root.val, path);
        }
        path.remove(path.size() - 1);
        
    }
    
    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        ArrayList<ArrayList<Integer>> result = pathSum(root, 22);
        System.out.println(result.size());
        System.out.println(result.get(0).get(2));
        
    }
}
    
