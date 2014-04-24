/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Hashtable;

/*
 problem:
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",
 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 @author chenbo
*/
public class InterleavingString 
{
    static Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
    static boolean isInterleave(String s1, String s2, String s3)
    {
        if(s1.length() + s2.length() != s3.length()) return false;
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()) return true;
        if(s3.isEmpty()) return false;
        if(s1.isEmpty()) return s2.equals(s3);
        if(s2.isEmpty()) return s1.equals(s3);
        StringBuilder keys = new StringBuilder();
        keys.append(s1);
        keys.append(s2);
        keys.append(s3);
        String key = keys.toString();
        if(s1.charAt(0) == s3.charAt(0) && s1.charAt(0) != s2.charAt(0))
        {
            if(table.containsKey(key)) return table.get(key);
            else
            {
                table.put(key, isInterleave(s1.substring(1), s2, s3.substring(1)));
            }
            return table.get(key);
        }
        else if(s2.charAt(0) == s3.charAt(0) && s1.charAt(0) != s2.charAt(0))
        {
            if(table.containsKey(key)) return table.get(key);
            else
            {
                table.put(key, isInterleave(s1, s2.substring(1), s3.substring(1)));
            }
            return table.get(key);
        }
        else if(s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0))
        {
            if(table.containsKey(key)) return table.get(key);
            else
            {
                table.put(key, isInterleave(s1.substring(1), s2, s3.substring(1)) || isInterleave(s1, s2.substring(1), s3.substring(1)));
            }
            return table.get(key);
        }
        else return false;
    }
    
    static boolean isInterleave2(String s1, String s2, String s3)
    {
        Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();
        return isInterleave(s1, s2, s3, table);
    }
    static boolean isInterleave(String s1, String s2, String s3,  Hashtable<String, Boolean> table) {
        if(table.containsKey(s1 + " " + s2)) return table.get(s1 + " " + s2);
        if(s3.length() == 0) return s1.length() == 0 && s2.length() == 0;
        if(s1.length() == 0) return s2.equals(s3);
        if(s2.length() == 0) return s1.equals(s3);
        
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        char c3 = s3.charAt(0);
        
        if(c1 == c3 && c2 == c3)
        {
            boolean result = isInterleave(s1.substring(1), s2, s3.substring(1), table) || 
                isInterleave(s1, s2.substring(1), s3.substring(1), table);
            table.put(s1 + " " + s2, result);
            return result;
        }
        else if(c1 == c3)
        {
            boolean result = isInterleave(s1.substring(1), s2, s3.substring(1), table);
            table.put(s1 + " " + s2, result);
            return result;
        }
        else if(c2 == c3)
        {
            boolean result = isInterleave(s1, s2.substring(1), s3.substring(1), table);
            table.put(s1 + " " + s2, result);
            return result;
        }
        else 
        {
            table.put(s1 + " " + s2, false);
            return false;
        }
    }
    public static void main(String[] args)
    {
        String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
        String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
        String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
        System.out.println(isInterleave2(s1, s2, s3));
    }
}
