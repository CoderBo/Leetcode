/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.*;

/**
 * problem:Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * @author chenbo
 */
public class MergekSortedLists 
{
    static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode i = l1;
        ListNode j = l2;
        ListNode head;
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(i.val < j.val)
        {
            head = new ListNode(i.val);
            i = i.next;
        }
        else
        {
            head = new ListNode(j.val);
            j = j.next;
        }
        
        ListNode p = head;
        while(i != null && j != null)
        {
            if(i.val < j.val)
            {
                p.next = new ListNode(i.val);
                i = i.next;
            }
            else
            {
                p.next = new ListNode(j.val);
                j = j.next;
            }
            p = p.next;
        }
        
        while(i != null)
        {
            p.next = new ListNode(i.val);
            p = p.next;
            i = i.next;
        }
        while(j != null)
        {
            p.next = new ListNode(j.val);
            p = p.next;
            j = j.next;
        }      
        return head;
    }
  /////////////////////////////////////////////////////////////////  
    ListNode mergeTwo(ListNode l1, ListNode l2)
    {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val)
        {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwo(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        ListNode head = null;
        for(ListNode l : lists)
        {
            head = mergeTwo(head, l);
        }
        return head;
    }
/////////////////////////////////////////////////////////////////
    static ListNode mergeKLists(ArrayList<ListNode> lists)
    {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        for(ListNode l : lists)
        {
            result = mergeTwoLists(result, l);
        }
        return result.next;
    }
    
    public static ListNode mergeKLists3(ArrayList<ListNode> lists)
    {
        if(lists.isEmpty()) return null;
        Comparator<ListNode> comparator = new Comparator<ListNode>()
        {
            @Override
            public int compare(ListNode list1, ListNode list2)
            {
                if(list1.val > list2.val) return 1;
                else if(list1.val == list2.val) return 0;
                else return -1;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);   
        for(ListNode l : lists)
        {
            if(l != null) heap.add(l);
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(!heap.isEmpty())
        {
            ListNode temp = heap.poll();
            p.next = temp;
            if(temp.next != null) heap.add(temp.next);
            p = p.next;
        }
        return head.next;
    }
}
