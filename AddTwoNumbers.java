/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * @author chenbo
 */
class ListNode
{
    int val;
    ListNode next;
    ListNode(int x) 
    {
        val = x;
        next = null;
    }
}
public class AddTwoNumbers 
{
    static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int lengthOfL1 = 0;
        int lengthOfL2 = 0;
        ListNode pointerOfL1 = l1;
        ListNode pointerOfL2 = l2;
        while(pointerOfL1 != null)
        {
            lengthOfL1++;
            pointerOfL1 = pointerOfL1.next;
        }
        while(pointerOfL2 != null)
        {
            lengthOfL2++;
            pointerOfL2 = pointerOfL2.next;
        }
        if(lengthOfL1 >= lengthOfL2) return addTwoNumbers2(l1, l2);
        else return addTwoNumbers2(l2, l1);
    }
    static ListNode addTwoNumbers2(ListNode l1, ListNode l2)
    {
        
        ListNode pointer = l1;
        while(l2.next != null)
        {
            pointer.val += l2.val;
            if(pointer.val >= 10)
            {
                pointer.val -= 10;
                pointer.next.val++;
            }
            pointer = pointer.next;
            l2 = l2.next;
        }
        pointer.val += l2.val;
        while(pointer.next != null)
        {
            if(pointer.val >= 10)
            {
                pointer.val -= 10;
                pointer.next.val++;
            }
            pointer = pointer.next;
        }
        if(pointer.val >= 10)
        {
            pointer.val -= 10;
            pointer.next = new ListNode(1);
        }
        return l1;
    }
    
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(1);
     //   l1.next = new ListNode(8);
    //    l1.next.next = new ListNode(9);
        
        ListNode l2 = new ListNode(0);
    //    l2.next = new ListNode(1);
    //    l2.next.next = new ListNode(9);
        ListNode newlist = addTwoNumbers(l1, l2);
        while(newlist != null)
        {
            System.out.print(newlist.val + " ");
            newlist = newlist.next;
        }
        
    }
}
