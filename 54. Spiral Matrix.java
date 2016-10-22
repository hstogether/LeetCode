/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

按照顺时针方向依次取数
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret=new ArrayList<Integer>();
        if(matrix.length<1)return ret;
        int column=matrix[0].length,raw=matrix.length;
        int l=0,r=column-1,t=0,b=raw-1;
        while(l<=r&&t<=b)
        {
			//从左到右
            for(int i=l;i<=r;i++)
                ret.add((Integer)matrix[t][i]);
            t++;
			//从上到下
            for(int i=t;i<=b;i++)
                ret.add((Integer)matrix[i][r]);
            r--;
            //从右到左          
            for(int i=r;i>=l&&b>=t;i--)//b>=t,不能取之前取过的数
                ret.add((Integer)matrix[b][i]);
            b--;
            //从下到上           
            for(int i=b;i>=t&&l<=r;i--)//l<=r,不能取之前取过的数
                ret.add((Integer)matrix[i][l]);
            l++;            
        }
        return ret;
    }
}