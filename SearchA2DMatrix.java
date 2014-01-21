/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * first integer of each row is greater than the last integer of the previous row.
 * @author chenbo
 */
public class SearchA2DMatrix 
{
    static boolean searchMatrix(int[][] matrix, int target)
    {
        int row = 0;
        int column = matrix[0].length - 1;
        while(row < matrix.length && column > 0)
        {
            if(matrix[row][column] == target) return true;
            else if(target > matrix[row][column]) row++;
            else column--;
        }
        return false;
    }
}
