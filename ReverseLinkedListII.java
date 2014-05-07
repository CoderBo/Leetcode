/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Reverse a linked list from position m to n.
 * Do it in-place and in one-pass.
 * @author chenbo
 */
public class ReverseLinkedListII 
{
    static ListNode reverseBetween(ListNode head, int m, int n)
    {
        if(head == null) return head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode p = preHead;
        for(int i = 0; i < m - 1; i++) p = p.next;
        ListNode end = preHead;
        for(int i = 0; i < n; i++) end = end.next;
        ListNode q = p.next;
        p.next = end;
        ListNode r = q.next;
        q.next = end.next;
        p = q;
        q = r;
        while(p != end)
        {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return preHead.next;
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
        
        head = reverseBetween(head, 2, 8);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
