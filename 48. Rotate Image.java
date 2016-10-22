/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

/*非原地AC算法*/
public class Solution {
    public void rotate(int[][] matrix) {
        int l=matrix.length;
        int[][] rmatrix=new int[l][l];
        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++)
                rmatrix[j][l-1-i]=matrix[i][j];
				
        for(int i=0;i<l;i++)
            for(int j=0;j<l;j++)
                matrix[i][j]=rmatrix[i][j];
    }
}

/*
原地移动
*/
public class Solution {
    public void rotate(int[][] matrix) {
        int l=matrix.length;
        for(int i=0;i<l/2+l%2;i++)//这里要在奇数时+1
            for(int j=0;j<l/2;j++)//这里不能加1
            {
                int tmp=matrix[j][l-1-i];
                matrix[j][l-1-i]=matrix[i][j];
                
                matrix[i][j]=matrix[l-1-i][l-1-j];
                matrix[l-1-i][l-1-j]=tmp;
                
                tmp=matrix[l-1-j][i];
                matrix[l-1-j][i]=matrix[i][j];
                
                matrix[i][j]=tmp;
            }
    }
}