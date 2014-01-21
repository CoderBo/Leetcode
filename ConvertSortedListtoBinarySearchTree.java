/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import com.sun.org.apache.bcel.internal.generic.L2D;

/**
 * problem:Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author chenbo
 */
public class ConvertSortedListtoBinarySearchTree 
{
    static int getLength(ListNode head)
    {
        int length = 0;
        while(head.next != null)
        {
            head = head.next;
            length++;
        }
        return length + 1;
    }
   
    static TreeNode sortedListToBST(ListNode head)
    {  
        if(head == null) return null;
        if(head.next == null)
        {
            return new TreeNode(head.val);
        }   
        int mid = 0;
        int length = getLength(head);
        mid = length / 2;
        
        ListNode p = head;      
        for(int i = 0; i < mid; i++)
        {
            p = p.next;
        }
        TreeNode node = new TreeNode(p.val);
        node.right = sortedListToBST(p.next);
        ListNode j = head;
        for(int i = 0; i < mid - 1; i++)
        {
            j = j.next;
        }
        j.next = null;
        node.left = sortedListToBST(head);
        return node;
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
     //   head.next.next = new ListNode(4);
     //   head.next.next.next = new ListNode(5);
    //    head.next.next.next.next = new ListNode(6);
        TreeNode node = sortedListToBST(head);
        System.out.println(node.val);
    }
}
