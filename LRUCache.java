/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * problem:
 * @author chenbo
 */
public class LRUCache 
{
    int capacity;
    Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    public LRUCache(int capacity) 
    {    
        this.capacity = capacity;
    }   
    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            int temp = map.get(key);
            map.remove(key);
            map.put(key, temp);
            return temp;
        }
        else return -1;
    }
    public void set(int key, int value) 
    {
        if(map.containsKey(key)) 
        {
            map.remove(key);
            map.put(key, value);
        }
        else
        {
            map.put(key, value);
        }
        if(map.size() > capacity)
        {
            int temp = map.keySet().iterator().next();
            map.remove(temp);
        }
    }
}
