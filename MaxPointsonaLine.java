/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;


import java.util.HashMap;


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
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int result = 0;
        for(int i = 0; i < points.length; i++)    
        {
            map.clear();
            int dup = 0;
            map.put(Double.MIN_VALUE, 1);
            for(int j = i + 1; j < points.length; j++)
            {
                if(points[i].x == points[j].x && points[i].y == points[j].y)
                {
                    dup++;
                    continue;
                }
                double key = points[i].x == points[j].x? Double.MAX_VALUE : 
                               0.0 + (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                if(map.containsKey(key)) map.put(key, map.get(key) + 1);
                else map.put(key, 2);
            }
            for(int a : map.values())
            {
                result = Math.max(result, a + dup);
            }
        }
        return result;
    
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
