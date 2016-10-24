<<<<<<< HEAD
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/


public class Solution {
    public int longestValidParentheses(String s) {
        Stack stack=new Stack<Integer>();
        Integer maxLength=0;
        Integer last=0;
        
        for(Integer i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(') stack.push(i);
            else
            {
                if(stack.isEmpty())last=i+1;
                else
                {
                    stack.pop();
                    if(stack.isEmpty())maxLength=Math.max(maxLength,i-last+1);
                    else maxLength=Math.max(maxLength,i-(Integer)stack.peek());
                }
            }
        }
        return maxLength;
    }
=======
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/


public class Solution {
    public int longestValidParentheses(String s) {
        Stack stack=new Stack<Integer>();
        Integer maxLength=0;
        Integer last=0;
        
        for(Integer i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(') stack.push(i);
            else
            {
                if(stack.isEmpty())last=i+1;
                else
                {
                    stack.pop();
                    if(stack.isEmpty())maxLength=Math.max(maxLength,i-last+1);
                    else maxLength=Math.max(maxLength,i-(Integer)stack.peek());
                }
            }
        }
        return maxLength;
    }
>>>>>>> ed27091b159975f65e5dcd56c64b08429e53bc31
}