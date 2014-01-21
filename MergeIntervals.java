/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * problem:Given a collection of intervals, merge all overlapping intervals.
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * @author chenbo
 */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class MergeIntervals 
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
    public static void main(String[] args)
    {
        ArrayList<Interval> a = new ArrayList<Interval>();
        a.add(new Interval(1, 4));
        a.add(new Interval(0, 4));
       // a.add(new Interval(8, 10));
       // a.add(new Interval(15, 18));
        a = merge(a);
        Interval b = a.get(0);
        System.out.println(b.start + " " + b.end);
        
    }
}
