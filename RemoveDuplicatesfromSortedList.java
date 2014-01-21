/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a sorted linked list, 
 * delete all duplicates such that each element appear only once.
 * @author chenbo
 */
public class RemoveDuplicatesfromSortedList 
{
    static ListNode deleteDuplicates(ListNode head)
    {
        if(head == null) return null;
        ListNode p = head;
        while(p.next != null)
        {
            if(p.next.val == p.val)
            {
                p.next = p.next.next;
            }
            else p = p.next;
        }
        return head;
    }
}
