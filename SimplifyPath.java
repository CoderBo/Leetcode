/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.LinkedList;

/**
 * problem:Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * @author chenbo
 */
public class SimplifyPath 
{
    static String simplifyPath(String path)
    {
        if(path.length() == 0) return path;
        String[] array = path.split("/");
        LinkedList<String> list = new LinkedList<String>();
        for(String s : array)
        {
            if(s.length() == 0 || s.equals(".")) continue;
            else if(s.equals(".."))
            {
                if(!list.isEmpty()) list.pop();
            }
            else list.push(s);
        }
        if(list.isEmpty()) list.push("");
        String result = "";
        while(!list.isEmpty()) result += "/" + list.removeLast();
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println(simplifyPath("/a/./b/../../c/"));
        //System.out.println(simplifyPath("/home/"));
    }
}
