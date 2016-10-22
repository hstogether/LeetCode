/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

/*
检测对角线：两个元素的行差和列差相等则说明在同一对角线上。
*/
public class Solution {
    List<List<String>> ret=new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        int[] ps=new int[n];//表示该行放置皇后的位置
        Arrays.fill(ps,Integer.MIN_VALUE);
        solve(ps,n,n);
        return ret;
    }
    
	//len皇后的个数
	//n当前放置第几个皇后
    void solve(int[] ps,int n,int len)
    {
        if(n==0)
        {
            List<String> entry=new ArrayList<String>();
            for(int i=0;i<len;i++)
            {
                char[] s=new char[len];
                Arrays.fill(s,'.');
                s[ps[i]]='Q';
                entry.add(String.valueOf(s));               
            }
            ret.add(entry);
        }
        else//放置该皇后
            for(ps[n-1]=len-1;ps[n-1]>=0;ps[n-1]--)
            {
                int i=len;
                while(--i>n-1)
                    if(ps[i]==ps[n-1]||Math.abs(ps[i]-ps[n-1])==Math.abs(n-1-i))break;
                if(i>n-1)continue;//当前位置不可放
                else solve(ps,n-1,len);
            }            

    }
}