/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.*;


/**
 * problem:Given two words (start and end), and a dictionary, find the length of 
 * shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * @author chenbo
 */
public class WordLadder 
{
    static int ladderLength(String start, String end, HashSet<String> dict)
    {
        if(start.length() != end.length()) return 0;
        if(dict.isEmpty()) return 0;
        int level = 1;
        Queue<String> upLevel = new LinkedList<String>();
        upLevel.offer(start);
        while(!upLevel.isEmpty())
        {
            level++;
            Queue<String> downLevel = new LinkedList<String>();
            while(!upLevel.isEmpty())
            {
                String item = upLevel.poll();
                for(int i = 0; i < item.length(); i++)
                {
                    char c = item.charAt(i);
                    for(char j = 'a'; j <= 'z'; j++)
                    {
                        if(j == c) continue;
                        StringBuilder temp = new StringBuilder(item);
                        temp.setCharAt(i, j); 
                        String newItem = temp.toString();
                        if(newItem.equals(end)) return level;
                        if(dict.contains(newItem))
                        {
                            downLevel.offer(newItem);
                            dict.remove(newItem);
                        }
                    }
                }
            }
            upLevel = downLevel;
        }
        return 0;
    }
    public static void main(String[] args)
    {
        HashSet<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(ladderLength("hit", "cog", set));
    }
}
