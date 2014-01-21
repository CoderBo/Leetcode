/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * @author chenbo
 */
public class RemoveDuplicatesfromSortedListII 
{
    static ListNode deleteDuplicates(ListNode head)
    {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null) return null;
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode p = prehead;
        while(p.next != null)
        {
            if(p.next.next == null || p.next.next.val != p.next.val) p = p.next;
            else
            {
                int value = p.next.val;
                ListNode j = p.next;
                while(true)
                {
                    if(j == null || j.val != value) break;
                    else j = j.next;
                }
                p.next = j;
            }
        }
        return prehead.next;
    }
}
