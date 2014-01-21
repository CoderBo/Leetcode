/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Sort a linked list in O(n log n) 
 * time using constant space complexity.
 * @author chenbo
 */
public class SortList 
{
    static ListNode sortList(ListNode head)
    {
        if(head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode normal = head;
        while(fast != null && fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            normal = normal.next;
        }
        ListNode rightHead = normal.next;
        normal.next = null;
       // System.out.println(normal.val);
        ListNode p1 = sortList(head);
        ListNode p2 = sortList(rightHead);
        ListNode result = merge(p1, p2);
        return result;
    }
    static ListNode merge(ListNode p1, ListNode p2)
    {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(p1 != null && p2 != null)
        {
            if(p1.val < p2.val)
            {
                p.next = new ListNode(p1.val);
                p = p.next;
                p1 = p1.next;
            }
            else
            {
                p.next = new ListNode(p2.val);
                p = p.next;
                p2 = p2.next;
            }
        }
        while(p1 != null)
        {
            p.next = new ListNode(p1.val);
            p = p.next;
            p1 = p1.next;
        }
        while(p2 != null)
        {
            p.next = new ListNode(p2.val);
            p = p.next;
            p2 = p2.next;
        }
        return head.next;
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(3);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(7);
        head = sortList(head);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
