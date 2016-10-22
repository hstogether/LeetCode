/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

递归求解
插空法：在已经匹配的括号串中的每个位置插入一对括号
用set去重复
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        Set ret=new HashSet<String>();
        ret.add("()");
        return new ArrayList<String>(insert(ret,n-1));
    }
    Set<String> insert(Set<String> set,int n)
    {

        if(n<1)return set;
        Set ret=new HashSet<String>();
        Iterator it=set.iterator();

        while(it.hasNext())
        {
            String s=it.next().toString();
            for(int i=0;i<=s.length();i++)
                ret.add(s.substring(0,i)+"()"+s.substring(i));
        }      
        return insert(ret,--n);
    }
}