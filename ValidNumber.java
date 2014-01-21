/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

/**
 * problem:Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 * @author chenbo
 */
public class ValidNumber 
{
    static boolean isNumber(String s)
    {
        s = s.trim();
        if(s.isEmpty()) return false;
        if(s.charAt(0) == '-' || s.charAt(0) == '+') s = s.substring(1);
        int numberOfPoint = 0;
        int numberOfE = 0;
        int numberOfDigit = 0;
        if(s.charAt(0) == 'e') return false;
        if(s.charAt(s.length() - 1) == 'e') return false;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') numberOfDigit++;
            else if(c == '.') 
            {
                if(numberOfE != 0) return false;
                numberOfPoint++;
                if(i + 1 < s.length() && s.charAt(i + 1) == 'e' && i == 0) return false;
            }
            else if(c == 'e') 
            {
                numberOfE++;
                if(i + 1 < s.length() && s.charAt(i + 1) == '.') return false;
                if(i + 1 < s.length() && s.charAt(i + 1) == '+')
                {
                    if(i + 1 == s.length() - 1) return false;
                    i++;
                }
                if(i + 1 < s.length() && s.charAt(i + 1) == '-')
                {
                    if(i + 1 == s.length() - 1) return false;
                    i++;
                }
            }
            else return false;
        }
        if(numberOfE > 1 || numberOfPoint > 1) return false;
        if(numberOfDigit == 0) return false;
        return true;
    }
    public static void main(String[] args)
    {
        System.out.println(isNumber("0"));
        System.out.println(isNumber(" 0.1 "));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("1 a"));
        System.out.println(isNumber("2e10"));
        System.out.println(isNumber(" .1"));
        System.out.println(isNumber(" . "));
        
    }
}
