/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * problem:Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * @author chenbo
 */
public class TextJustification 
{
    static ArrayList<String> fullJustify(String[] words, int L)
    {
        ArrayList<String> result = new ArrayList<String>();
        if(L == 0)
        {
            result.add("");
            return result;
        }
        Queue<String> queue = new LinkedList<String>();
        int lengthOfOneLine = 0;
        int lengthOfWords = 0;
        int i = 0;
        while(i < words.length)
        {
            String word = words[i];
            if(word.length() == L) 
            {
                if(!queue.isEmpty())
                {
                    int numberOfWords = queue.size();
                    if(numberOfWords == 1)
                    {
                        String temp = queue.poll();
                        StringBuilder sub = new StringBuilder();
                        sub.append(temp);
                        for(int j = 0; j < L - temp.length(); j++) sub.append(" ");
                        result.add(sub.toString());
                        lengthOfOneLine = 0;
                        lengthOfWords = 0;
                    }
                    else
                    {
                        int lengthOfSpace = L - lengthOfWords;
                        int slot = numberOfWords == 1? 1 : lengthOfSpace / (numberOfWords - 1);
                        int other = numberOfWords == 1? 0 : lengthOfSpace % (numberOfWords - 1);
                        StringBuilder sub = new StringBuilder();
                        while(!queue.isEmpty())
                        {
                            sub.append(queue.poll());
                            if(!queue.isEmpty()) 
                            {
                                for(int j = 0; j < slot; j++) sub.append(" ");
                                if(other != 0) 
                                {
                                    sub.append(" ");
                                    other--;
                                }
                            }
                        }
                        result.add(sub.toString());
                        lengthOfOneLine = 0;
                        lengthOfWords = 0;
                    }
                }
                
                StringBuilder sub = new StringBuilder();
                sub.append(word);
                result.add(sub.toString());
                i++;
                continue;
            }
            else if(lengthOfOneLine + 1 + word.length() <= L)
            {
                queue.offer(word);
                if(queue.size() != 1) lengthOfOneLine += 1;
                lengthOfOneLine += word.length();
                lengthOfWords += word.length();
                i++;
            }
            else
            {
                int numberOfWords = queue.size();
                if(numberOfWords == 1)
                {
                    String temp = queue.poll();
                    StringBuilder sub = new StringBuilder();
                    sub.append(temp);
                    for(int j = 0; j < L - temp.length(); j++) sub.append(" ");
                    result.add(sub.toString());
                    lengthOfOneLine = 0;
                    lengthOfWords = 0;
                }
                else
                {
                    int lengthOfSpace = L - lengthOfWords;
                    int slot = numberOfWords == 1? 1 : lengthOfSpace / (numberOfWords - 1);
                    int other = numberOfWords == 1? 0 : lengthOfSpace % (numberOfWords - 1);
                    StringBuilder sub = new StringBuilder();
                    while(!queue.isEmpty())
                    {
                        sub.append(queue.poll());
                        if(!queue.isEmpty()) 
                        {
                            for(int j = 0; j < slot; j++) sub.append(" ");
                            if(other != 0) 
                            {
                                sub.append(" ");
                                other--;
                            }
                        }
                    }
                    result.add(sub.toString());
                    lengthOfOneLine = 0;
                    lengthOfWords = 0;
                }
            }
        }
        
        if(!queue.isEmpty())
        {
            StringBuilder sub = new StringBuilder();
            int space = 0;
            while(!queue.isEmpty())
            {
                sub.append(queue.poll());
                if(!queue.isEmpty()) 
                {
                    sub.append(" ");
                    space++;
                }
            }
            for(int j = 0; j < L - lengthOfWords - space; j++) sub.append(" ");
            result.add(sub.toString());
        }
        return result;
    }
    public static void main(String[] args)
    {
        String[] array = {"What","must","be","shall","be."};
        ArrayList<String> list = fullJustify(array, 12);
        for(String s : list)
        {
            System.out.println(s);
        }
    }
}
