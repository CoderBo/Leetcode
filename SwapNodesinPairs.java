/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a linked list, swap every two adjacent nodes and return its head.
 * @author chenbo
 */
public class SwapNodesinPairs 
{
    static ListNode swapPairs(ListNode head)
    {
        if(head == null || head.next == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode n1 = helper;
        ListNode n2 = head;
        while(n2 != null && n2.next != null)
        {
            ListNode temp = n2.next.next;
            n2.next.next = n1.next;
            n1.next = n2.next;
            n2.next = temp;
            n1 = n2;
            n2 = n1.next;
        }
        return helper.next;
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        head = swapPairs(head);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
