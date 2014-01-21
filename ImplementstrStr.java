/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack,
 * or null if needle is not part of haystack.
 * @author chenbo
 */
public class ImplementstrStr 
{
    static String strStr(String haystack, String needle)
    {
        int idx = haystack.indexOf(needle);  
        if(idx < 0) return null;
        else return haystack.substring(idx);    
    }
    public static void main(String[] args) 
    {  
        String haystack = "testing test";  
        String needle = "test";  
        System.out.println(strStr(haystack, needle));  
    }  
}   
