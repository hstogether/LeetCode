/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret=new int[n][n];
        if(n<1)return ret;//有没有都可以
        int l=0,t=0,r=n-1,b=n-1;
        int count=0;
        while(l<=r&&t<=b)
        {
            for(int i=l;i<=r;i++)ret[t][i]=++count;
            t++;
            
            for(int i=t;i<=b;i++)ret[i][r]=++count;
            r--;
            
            for(int i=r;i>=l&&b>=t;i--)ret[b][i]=++count;
            b--;
            
            for(int i=b;i>=t&&l<=r;i--)ret[i][l]=++count;
            l++;
        }
        return ret;
    }
}