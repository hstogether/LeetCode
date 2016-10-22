/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

二分查找
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret={-1,-1};
        int l=0,r=nums.length-1,m;
        while(l>=0&&r<nums.length&&l<=r)
        {
            m=(l+r)/2;
            if(nums[m]<target)l=m+1;
            else if(nums[m]>target)r=m-1;
            else
            {
                int i=m,j=m;
                while(--i>=0&&nums[i]==target);
                while(++j<nums.length&&nums[j]==target);
                ret[0]=++i;
                ret[1]=--j;
                return ret;
            }
        }
        return ret;
    }
}