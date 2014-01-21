/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.*;;

/**
 * problem:Clone an undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors.
 * @author chenbo
 */
 class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
public class CloneGraph 
{
    static UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        Hashtable<UndirectedGraphNode, UndirectedGraphNode> table = new Hashtable<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        table.put(node, newNode);
        queue.offer(node);
        while(!queue.isEmpty())
        {
            UndirectedGraphNode p = queue.poll();
            for(UndirectedGraphNode i : p.neighbors)
            {
                if(!table.containsKey(i))
                {
                    table.put(i, new UndirectedGraphNode(i.label));
                    queue.offer(i);
                }
            }
        }
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        set.add(node);
        queue.add(node);
        while(queue.isEmpty())
        {
            UndirectedGraphNode p = queue.poll();
            for(UndirectedGraphNode i : p.neighbors)
            {
                table.get(p).neighbors.add(table.get(i));
                if(!set.contains(i)) queue.offer(i);
            }
        }
        return newNode;
    }
}
