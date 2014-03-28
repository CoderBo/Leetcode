/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a list, 
 * rotate the list to the right by k places, where k is non-negative.
 * @author chenbo
 */
public class RotateList 
{
    static ListNode rotateRight(ListNode head, int n)
    {
        if(head == null) return null;
        ListNode p = head;
        ListNode temp = head;
        int length = 0;
        while(temp != null)  
        {
            temp = temp.next;
            length++;
        }
        n = n % length;
        if(n == 0) return head;
        for(int i = 0; i < n; i++)
        {
            if(p.next == null) return head;
            p = p.next;
        }
        ListNode low = head;
        while(p.next != null)
        {
            p = p.next;
            low = low.next;
        }
        ListNode newHead = low.next;
        low.next = null;
        p.next = head;
        return newHead;
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        head = rotateRight(head, 1);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
