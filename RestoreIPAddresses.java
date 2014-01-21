/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;

/**
 * problem:Given a string containing only digits,
 * restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * @author chenbo
 */
public class RestoreIPAddresses 
{
    static ArrayList<String> restoreIpAddresses(String s, int n)
    {
        if(n == 1)
        {
            ArrayList<String> result = new ArrayList<String>();
            if(s.length() > 3 || s.length() == 0) return result;
            if(s.length() == 3 && s.compareTo("255") > 0) return result;
            if(s.length() != 1 && s.charAt(0) == '0') return result;
            result.add(s);
            return result;
        }
        else
        {
            ArrayList<String> result = new ArrayList<String>();
            if(s == null || s.length() == 0 || s.length() > n * 3 || s.length() < n) return result;
          
            String first = s.substring(0, 1);
            ArrayList<String> sub = restoreIpAddresses(s.substring(1), n - 1);
            if(sub != null)
            {
                for(String i : sub)
                {
                    result.add(first + "." + i);
                }
            }
            
            String second = s.substring(0, 2);
            sub = restoreIpAddresses(s.substring(2), n - 1);
            if(second.charAt(0) == '0') sub = null;
            if(sub != null)
            {
                for(String i : sub)
                {
                    result.add(second + "." + i);
                }
            }
            if(s.length() >= 3)
            {
                String third = s.substring(0, 3);
                if(third.compareTo("255") > 0) return result;
                sub = restoreIpAddresses(s.substring(3), n - 1);
                if(third.charAt(0) == '0') sub = null;
                if(sub != null)
                {
                    for(String i : sub)
                    {
                        result.add(third + "." + i);
                    }
                }
            }
            return result;
        } 
    }
    static ArrayList<String> restoreIpAddresses(String s)
    {
        if(s.length() == 0) return new ArrayList<String>();
        return restoreIpAddresses(s, 4);
    }
    public static void main(String[] args)
    {
        //System.out.println("1234".substring(4));
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
