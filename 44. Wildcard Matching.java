/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

回溯

*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int sCurrent=0;
        int pStar=-1;
        int i=0,j=0;
        
        while(i<s.length())
        {
            if(j<p.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'))
            {
                i++;
                j++;
            }
            else if(j<p.length()&&p.charAt(j)=='*')
            {//记录s的位置，p增加。相当于*和空串匹配
                sCurrent=i;
                pStar=j++;
            }
            else if(pStar>-1)
            {//每次给s增加一个字符开始匹配。这是回溯。
			 //只需要考虑回溯到最后一个*即可，不需要考虑前面的*（因为不会产生新的匹配结果）。
                i=++sCurrent;
                j=pStar+1;
            }
            else return false;//如果s没有被匹配完，则返回false
        }
        
		//匹配p末尾的*
        while(j<p.length()&&p.charAt(j)=='*')j++;
        return j==p.length();
    }
}