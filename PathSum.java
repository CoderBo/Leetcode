/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf 
 * path such that adding up all the values 
 * along the path equals the given sum.
 * @author chenbo
 */
public class PathSum 
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null) return false;
        if(root.left == null && root.right == null)
        {
            if(root.val == sum) return true;
            else return false;
        }
        else if(root.left == null)
        {
            root.right.val += root.val;
            return hasPathSum(root.right, sum);
        }
        else if(root.right == null)
        {
            root.left.val += root.val;
            return hasPathSum(root.left, sum);
        }
        root.left.val += root.val;
        root.right.val += root.val;
        
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
    
    
}
