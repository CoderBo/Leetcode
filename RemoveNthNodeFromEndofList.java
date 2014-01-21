/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a linked list, remove the nth node from the end of list and return its head.
 * @author chenbo
 */

public class RemoveNthNodeFromEndofList 
{
    static ListNode removeNthFromEnd(ListNode head, int n)
    {
        if(head.next == null) return null;
        ListNode faster = head;
        ListNode normal = head;
        for(int i = 0; i < n; i++)
        {
            faster = faster.next;
        }
        if(faster == null) return head.next;
        while(faster.next != null)
        {
            faster = faster.next;
            normal = normal.next;
        }
        normal.next = normal.next.next;
        return head;
    }
    
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
      //  head.next.next.next = new ListNode(4);
      //  head.next.next.next.next = new ListNode(5);
        
        head = removeNthFromEnd(head, 3);
        ListNode pointer = head;
        while(pointer != null)
        {
            System.out.println(pointer.val);
            pointer = pointer.next;
        }
    }
}
