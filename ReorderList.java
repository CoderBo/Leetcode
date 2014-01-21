/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:
 * @author chenbo
 */
public class ReorderList 
{
    static ListNode reverseList(ListNode head)
    {
        if(head == null) return null;
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        while(q != null)
        {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        head = p;
        return head;
    }
    static void reorderList(ListNode head)
    {
        if(head == null) return;
        ListNode normal = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            normal = normal.next;
        }
        ListNode secondHead = normal.next;
        normal.next = null;
        secondHead = reverseList(secondHead);
        ListNode p = head;
        ListNode q = secondHead;
        while(q != null)
        {
            ListNode nextP = p.next;
            ListNode nextQ = q.next;
            p.next = q;
            q.next = nextP;
            p = nextP;
            q = nextQ;
        }
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        reorderList(head);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
