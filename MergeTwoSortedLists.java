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
        ListNode i = l1;
        ListNode j = l2;
        ListNode head;
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(i.val < j.val)
        {
            head = new ListNode(i.val);
            i = i.next;
        }
        else
        {
            head = new ListNode(j.val);
            j = j.next;
        }
        
        ListNode p = head;
        while(i != null && j != null)
        {
            if(i.val < j.val)
            {
                p.next = new ListNode(i.val);
                i = i.next;
            }
            else
            {
                p.next = new ListNode(j.val);
                j = j.next;
            }
            p = p.next;
        }
        
        while(i != null)
        {
            p.next = new ListNode(i.val);
            p = p.next;
            i = i.next;
        }
        while(j != null)
        {
            p.next = new ListNode(j.val);
            p = p.next;
            j = j.next;
        }      
        return head;
    }
}
