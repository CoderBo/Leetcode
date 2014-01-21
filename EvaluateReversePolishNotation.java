/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Stack;

/**
 * problem:Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * @author chenbo
 */
public class EvaluateReversePolishNotation 
{
    static int evalRPN(String[] tokens)
    {
        if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens)
        {
            if(s.equals("+"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            }
            else if(s.equals("-"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }
            else if(s.equals("*"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            }
            else if(s.equals("/"))
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
            else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
    public static void main(String[] args)
    {
        String[] array = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(array));
    }
}
