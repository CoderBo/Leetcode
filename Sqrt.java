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
    public static void main(String[] args)
    {
        System.out.println(sqrt(668605518));
    }
}
 