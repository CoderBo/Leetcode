/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author chenbo
 */
public class MergeTwoSortedLists 
{
    static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(0);
        ListNode current = head;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p = l1;
        ListNode q = l2;
        while(p != null && q != null)
        {
            if(p.val < q.val)
            {
                ListNode item = new ListNode(p.val);
                current.next = item;
                p = p.next;
            }
            else
            {
                ListNode item = new ListNode(q.val);
                current.next = item;
                q = q.next;
            }
            current = current.next;
        }
        while(p != null)
        {
            ListNode item = new ListNode(p.val);
            current.next = item;
            current = current.next;
            p = p.next;
        }
        while(q != null)
        {
            ListNode item = new ListNode(q.val);
            current.next = item;
            current = current.next;
            q = q.next;
        }
        return head.next;
    }
}
