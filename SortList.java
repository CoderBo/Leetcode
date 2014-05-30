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
    static ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode preHead = new ListNode(0);
        preHead.next = head1;
        ListNode p = preHead;
        while(head1 != null && head2 != null)
        {
            if(head1.val < head2.val)
            {
                head1 = head1.next;
            }
            else
            {
                ListNode temp = head2.next;
                head2.next = p.next;
                p.next = head2;
                head2 = temp;
            }
            p = p.next;
        }
        if(head2 != null)
        {
            p.next = head2;
        }
        return preHead.next;
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
