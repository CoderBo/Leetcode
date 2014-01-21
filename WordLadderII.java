/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import static leetcode.WordLadder.ladderLength;
/**
 * problem:Given two words (start and end), and a dictionary, 
 * find all shortest transformation sequence(s) from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 * [
 *  ["hit","hot","dot","dog","cog"],
 *  ["hit","hot","lot","log","cog"]
 * ]

 * @author chenbo
 */
class Node
{
    Node parent;
    String value;

    public Node(String value) 
    {
        this.value = value;
        parent = null;
    }
}
public class WordLadderII 
{
    static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict)
    {
        
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        dict.add(start);
        dict.add(end);
        if(start.length() != end.length()) return result;
        if(dict.isEmpty()) return result;
        Hashtable<String, HashSet<String>> adjacency = new Hashtable<String, HashSet<String>>();
        for(String word : dict)
        {
            HashSet<String> set = new HashSet<String>();
            char [] chars = word.toCharArray(); 
            for(int i = 0; i < word.length(); i++)
            {
                char old = word.charAt(i);
                for(char j = 'a'; j <= 'z'; j++)
                {
                    if(j == old) continue;
                    chars[i] = j;
                    String newItem = new String(chars); 
                    if(dict.contains(newItem))
                    {
                        set.add(newItem);
                    }
                }
                chars[i] = old;
            }
            if(set.isEmpty()) continue;
            adjacency.put(word, set);
        }
        if(adjacency.isEmpty()) return result;
        //System.out.println(adjacency);
        
        HashSet<String> record = new HashSet<String>();
        Queue<Node> uplevel = new LinkedList<Node>();
        uplevel.offer(new Node(start));
        int level = 0;
        int finalLevel = Integer.MAX_VALUE;
        record.add(start);
        ArrayList<Node> resultNodes = new ArrayList<Node>();
        while((!uplevel.isEmpty()) && level < finalLevel)
        {
            Queue<Node> currentLevel = new LinkedList<Node>();
            ArrayList<String> backup = new ArrayList<String>();
            while(!uplevel.isEmpty())
            {
                Node currentNode = uplevel.poll();
                String word = currentNode.value;
                backup.add(word);
                if(!adjacency.containsKey(word)) continue;
                HashSet<String> tempSet = adjacency.get(word);
                if(tempSet.contains(end))
                {
                    Node finalNode = new Node(end);
                    finalNode.parent = currentNode;
                    resultNodes.add(finalNode);
                    finalLevel = level;
                }
                else
                {
                    for(String s : tempSet)
                    {
                        if(record.contains(s)) continue;   
                        Node newNode = new Node(s);
                        newNode.parent = currentNode;
                        currentLevel.offer(newNode);
                    }
                }
            }
            for(String s : backup) record.add(s);
            uplevel = currentLevel;
            level++;            
        }
        for(Node n : resultNodes)
        {
            ArrayList<String> temp = new ArrayList<String>();
            while(n != null)
            {
                temp.add(n.value);
                n = n.parent;
            }
            Collections.reverse(temp);
            result.add(temp);
        }
        return result;
    }
    
    
    public static void main(String[] args)
    {   
        HashSet<String> set = new HashSet<String>();
        set.add("ted");
        set.add("tex");
        set.add("red");
        set.add("tax");
        set.add("tad");
        set.add("den");
        set.add("rex");
        set.add("pee");      
        HashSet<String> set2 = new HashSet<String>();
        set.add("hot");
        set.add("dog");        
        System.out.println(findLadders("red", "tax", set));
    }
}
