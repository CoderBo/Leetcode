/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.HashSet;

/**
 * problem:Given a linked list, 
 * return the node where the cycle begins. If there is no cycle, return null.
 * @author chenbo
 */
public class LinkedListCycleII 
{
    static ListNode detectCycle(ListNode head)
    {
        HashSet<ListNode> set = new HashSet<ListNode>();
        // The collection we use to store the node which we already visited
        while(head != null)
        {
            if(set.contains(head)) return head;
            //we find the node which appears twice, that's the one
            else 
            {
                //if it doesn't appear, then put it to the set
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
