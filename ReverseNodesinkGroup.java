/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a linked list, reverse the nodes of a linked list 
 * k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * @author chenbo
 */
public class ReverseNodesinkGroup 
{
    static ListNode reverseKGroup(ListNode head, int k)
    {
        if(head == null || head.next == null) return head;
        if(k <= 1) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode start = preHead;
        while(true)
        {
            ListNode end = start;
            for(int i = 0; i < k; i++)
            {
                end = end.next;
                if(end == null) return preHead.next;
            }
            ListNode newStart = start.next;
            ListNode p = start.next;
            ListNode q = p.next;
            p.next = end.next;
            start.next = end;
            while(p != end)
            {
                ListNode r = q.next;
                q.next = p;
                p = q;
                q = r;
            }
            start = newStart;
        }
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head = reverseKGroup(head, 3);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
