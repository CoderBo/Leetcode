/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Implement pow(x, n).
 * @author chenbo
 */
public class Pow 
{
    static double pow(double x, int n) 
    {
        return Math.pow(x, n);
    }
    static double pow2(double x, int n)
    {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(x == 0.0) return 0.0;
        double temp = pow2(x, Math.abs(n / 2));
        if(n > 0)
        {
            if(n % 2 == 0) return temp * temp;
            else return temp * temp * x;
        }
        else
        {
            if(n % 2 == 0) return 1 / (temp * temp);
            else return 1 / (temp * temp * x);
        }
    }
    public static void main(String[] args)
    {
        System.out.println(pow2(-2,-3));
    }
}
