/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Implement int sqrt(int x)
 * @author chenbo
 */
public class Sqrt 
{
    static int sqrt(int x)
    {
        return (int)Math.sqrt(x);
    }
    static int sqrt2(int x) {
        if(x == 0) return x;
        double pre = 0;
        double y = 1;
        while(pre != y)
        {
            pre = y;
            y = (y + x / y) / 2;
        }
        return (int)y;
    }
    
    static int sqrt3(int x) {
       int start = -1;
       int end = x + 1;
       while(end - start > 1)
       {
           int mid = (start + end) / 2;
           if(mid >= x / mid) end = mid;
           else start = mid;
       }
       return end;
   }
 
    public static void main(String[] args)
    {
        System.out.println(sqrt3(668605518));
    }
}
 