/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * problem:Given n points on a 2D plane, 
 * find the maximum number of points that lie on the same straight line.
 * @author chenbo
 */

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class MaxPointsonaLine 
{
     static int maxPoints(Point[] points)
     {
        if(points.length <= 2) return points.length;
        Hashtable<Double, Integer> table = new Hashtable<Double, Integer>();
        int max = 0;
        for(int i = 0; i < points.length; i++)
        {
            table.clear();
            int duplicate = 0;
            for(int j = i + 1; j < points.length; j++)
            {
                if(points[i].x == points[j].x && points[i].y == points[j].y)
                {
                    duplicate++;
                    continue;
                }
                double sloup = 0;
                if(points[i].x == points[j].x) sloup = Integer.MAX_VALUE;
                else if(points[i].y == points[j].y) sloup = 0.0;
                else sloup = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                if(table.containsKey(sloup))
                {
                    int time = table.get(sloup);
                    time++;
                    table.put(sloup, time);
                }
                else table.put(sloup, 1);
            }
            int subMax = duplicate + 1;
            for(int a : table.values()) subMax = Math.max(subMax, a + 1 + duplicate);
            max = Math.max(max, subMax);
        }
        return max;
    }
    public static void main(String[] args)
    {
        Point[] points = new Point[3];
        points[0] = new Point(2, 3);
        points[1] = new Point(3, 3);
        points[2] = new Point(-5, 3);
       /* points[3] = new Point(0, -70);
        points[4] = new Point(0, -70);
        points[5] = new Point(1, -1);
        points[6] = new Point(21, 10);
        points[7] = new Point(42, 90);
        points[8] = new Point(-42, -230);*/
        System.out.println(maxPoints(points));
    }
}
