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
    public static ArrayList<ArrayList<Integer>> pathSum2(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        ArrayList<Integer> sub = new ArrayList<Integer>();
        generate(root, sum, sub, result);
        return result;
    }
    static void generate(TreeNode root, int sum, ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> result)
    {
        if(root == null && sum == 0)
        {
            result.add(sub);
            return;
        }
        ArrayList<Integer> subLeft = new ArrayList<Integer>(sub);
        ArrayList<Integer> subRight = new ArrayList<Integer>(sub);
        generate(root.left, sum - root.val, subLeft, result);
        generate(root.right, sum - root.val, subRight, result);
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
    
