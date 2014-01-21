/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Given a linked list, determine if it has a cycle in it.
 * @author chenbo
 */
import java.util.*;
public class LinkedListCycle 
{
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashSet<ListNode> set = new HashSet<ListNode>();
        // The collection we use to store the node which we already visited
        while(head != null)
        {
            if(set.contains(head)) return true;
            //we find the node which appears twice, that's the one
            else 
            {
                //if it doesn't appear, then put it to the set
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }
}
