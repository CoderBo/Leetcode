/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Sort a linked list using insertion sort.
 * @author chenbo
 */
public class InsertionSortList 
{
    static ListNode insertionSortList(ListNode head) 
    {
        if(head == null || head.next == null) return head;
        ListNode preHead = new ListNode(Integer.MIN_VALUE);
        preHead.next = head;
        ListNode p = head;
        while(p.next != null)
        {
            if(p.val <= p.next.val) p = p.next;
            else
            {
                ListNode temp = p.next;
                p.next = p.next.next;
                ListNode q = preHead;
                while(q != p)
                {
                    if(temp.val >= q.val && temp.val < q.next.val)
                    {
                        temp.next = q.next;
                        q.next = temp;
                        break;
                    }
                    else q = q.next;
                }
            }
        }
        return preHead.next;
    }
    public static void main(String[] args)
    {
        ListNode head = new ListNode(-2147483647);
        head.next = new ListNode(-2147483648);
       // head.next.next = new ListNode(3);
        head = insertionSortList(head);
        while(head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }
}