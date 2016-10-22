/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

*/

/*Accepted
两个指针left和right，分别从两端开始向中间移动，
寻找比最小值还小的高度便是可以容纳的水量。
*/
public class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1,ret=0;
        while(l<r)
        {
            int min=Math.min(height[l],height[r]);
            if(height[l]==min)while(++l<r&&height[l]<min)ret+=min-height[l];
            else while(--r>l&&height[r]<min)ret+=min-height[r];
        }
        return ret;
    }
}

/*
Some Error
cannot comupte like [3,1,2]
[]
[]  []
[][][]

*/
public class Solution {
    public int trap(int[] height) {
        int sum1=0,sum2=0;
        for(int i=0;i<height.length;sum1+=height[i++]);
        for(int i=0;i<height.length;)
        {
            int j=i+1;
            for(;j<height.length;j++)
                if(height[j]>=height[i])
                {
                    sum2+=height[i]*(j-i);
                    i=j;
                    break;
                }
            if(j>=height.length)sum2+=height[i++];
        }
        return sum2-sum1;
    }
}