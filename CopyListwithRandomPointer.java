/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Hashtable;

/**
 * problem:A linked list is given such that each node contains an additional 
 * random pointer which could point to any node in the list or null.
 * @author chenbo
 */
class RandomListNode 
{
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class CopyListwithRandomPointer 
{
    static RandomListNode copyRandomList(RandomListNode head)
    {
        if(head == null) return null;
        Hashtable<RandomListNode, RandomListNode> table = new Hashtable<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode p = head;
        RandomListNode q = newHead;
        table.put(p, q);
        p = p.next;
        while(p != null)
        {
            q.next = new RandomListNode(p.label);
            table.put(p, q.next);
            p = p.next;
            q = q.next;
        }
        p = head;
        q = newHead;
        while(p != null)
        {
            if(p.random == null) q.random = null;
            else q.random = table.get(p.random);
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
    public static void main(String[] args)
    {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        head.random = head.next.next.next.next;
        head.next.random = head;
        head.next.next.random = null;
        head.next.next.next.random = head.next.next.next;
        head.next.next.next.next.random = head.next;
        RandomListNode newHead = copyRandomList(head);
    }
}
