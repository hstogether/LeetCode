/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

public class Solution {
    int ret=0;
    public int totalNQueens(int n) {
        int[] ps=new int[n];
        solve(ps,n,n);
        return ret;
    }
    void solve(int[] ps,int n,int len)
    {
        if(n==0)ret++;
        else 
            for(ps[n-1]=len-1;ps[n-1]>=0;ps[n-1]--)
            {
                int i=len;
                while(--i>n-1)
                    if(ps[n-1]==ps[i]||Math.abs(ps[n-1]-ps[i])==Math.abs(n-1-i))break;
                if(i>n-1)continue;
                else solve(ps,n-1,len);
            }
    }
}