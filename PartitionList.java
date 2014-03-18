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
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode p = leftHead;
        ListNode q = rightHead;
        ListNode current = head;
        while(current != null)
        {
            if(current.val < x)
            {
                p.next = new ListNode(current.val);
                p = p.next;
            }
            else
            {
                q.next = new ListNode(current.val);
                q = q.next;
            }
            current = current.next;
        }
        p.next = rightHead.next;
        return leftHead.next;
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
