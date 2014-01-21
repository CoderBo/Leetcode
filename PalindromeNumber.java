/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:
 * @author chenbo
 */
public class PalindromeNumber 
{
    public static int inverse(int n)
    {
        int sub = 0;
        int result = 0;
        while(n > 0)
        {
            sub = n % 10;
            n = n / 10;
            result = (result + sub) * 10;
        }
        return result / 10;
    }   
    static int getLength(int n)
    {
        int count = 0;
        while(n != 0)
        {
            count++;
            n /= 10;
        }
        return count;
    }
    static boolean isPalindrome(int x)
    {
        if(x < 0) return false;
        int front = x / (int)(Math.pow(10, getLength(x) / 2));
        int end = x - front * (int)(Math.pow(10, getLength(x) / 2));
        front = getLength(x) % 2 == 0 ? front:front / 10;
        return inverse(front) == end;
    }
  static boolean isPalindrome2(int x) {
  if (x < 0) return false;
  int div = 1;
  while (x / div >= 10) {
    div *= 10;
  }        
  while (x != 0) {
      System.out.println(x + " " + div);
    int l = x / div;
    int r = x % 10;
    if (l != r) return false;
    x = (x % div) / 10;
    div /= 100;
  }
  return true;
}
    public static void main(String[] args)
    {
        System.out.println(isPalindrome2(1000110001));
       // System.out.println(inverse(86));
    }
   
}
