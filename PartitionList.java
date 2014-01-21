/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * @author chenbo
 */
public class PartitionList 
{
    static ListNode partition(ListNode head, int x)
    {
        if(head == null) return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode tail = head;
        int length = 0;
        while(tail.next != null)
        {
            tail = tail.next;
            length++;
        }
        ListNode p = preHead;
        for(int i = 0; i <= length; i++)
        {
            if(p.next.val >= x)
            {
                tail.next = p.next;
                tail = tail.next;
                p.next = p.next.next;
                tail.next = null;
            }
            else p = p.next;
        }
        return preHead.next;
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        
        head = partition(head, 3);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
