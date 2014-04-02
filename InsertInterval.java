/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * problem:Given a set of non-overlapping intervals, 
 * insert a new interval into the intervals (merge if necessary).
 * @author chenbo
 */
public class InsertInterval 
{
    static ArrayList<Interval> merge(ArrayList<Interval> intervals)
    {
        Comparator<Interval> comparator = new Comparator<Interval>()
        {
            @Override
            public int compare(Interval p1, Interval p2)
            {
                if(p1.start < p2.start) return -1;
                else if(p1.start > p2.start) return 1;
                else return 0;
            }
        };
        Collections.sort(intervals, comparator);
        ArrayList<Interval> result = new ArrayList<Interval>();
        intervals.add(new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
        int i = 0;
        int j = 1;
        while(i < intervals.size() && j < intervals.size())
        {
            Interval first = intervals.get(i);
            Interval second = intervals.get(j);
            if(first.end < second.start)
            {
                result.add(first);
                i = j;
                j++;
            }
            else if(first.end >= second.start && first.end <= second.end)
            {
                first.end = second.end;
                j++;
            }
            else
            {
                j++;
            }
        }
        return result;
    }
    static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
    {
        intervals.add(newInterval);
        return merge(intervals);
    }
    
    
    static ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(newInterval == null) return intervals;
        int a = Integer.MIN_VALUE;
        Interval item = new Interval(a, a);
        int i = 0;
        for(; i < intervals.size(); i++)
        {
            Interval current = intervals.get(i);
            if(newInterval.start > current.end) result.add(current);
            if(newInterval.start >= current.start && newInterval.start <= current.end)
            {
                if(item.start == a) item.start = current.start;
            }
            if(newInterval.start < current.start)
            {
                if(item.start == a) item.start = newInterval.start;
            }
            if(newInterval.end < current.start)
            {
                item.end = newInterval.end;
                result.add(item);
                break;
            }
            if(newInterval.end >= current.start && newInterval.end <= current.end)
            {
                item.end = current.end;
                result.add(item);
                i++;
                break;
            }
        }
        for(; i< intervals.size(); i++) result.add(intervals.get(i));
        if(item.start == a && item.end == a) result.add(newInterval);
        else if(item.end == a)
        {
            item.end = newInterval.end;
            result.add(item);
        }
        System.out.println(item.start + " " + item.end);
        return result;
    }
    public static void main(String[] args)
    {
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1, 5));
        list.add(new Interval(6, 8));
        
        insert2(list, new Interval(5, 6));
   
    }
}
