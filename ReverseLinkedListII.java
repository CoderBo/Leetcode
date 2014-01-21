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
        if(m == n) return head;
        ListNode front;
        boolean flag = false;
        if(m == 1) 
        {
            front = new ListNode(0);
            front.next = head;
            flag = true;
        }
      
        else
        {
            front = head;
            for(int i = 0; i < m - 2; i++)
            {
                front = front.next;
            }
        }
        
        ListNode end = head;
        for(int i = 0; i < n; i++)
        {
            end = end.next;
        }
        ListNode p = front.next;
        ListNode q = p.next;    
        p.next = end;
        while(q != end)
        {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        front.next = p;
        return flag? front.next : head;
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
