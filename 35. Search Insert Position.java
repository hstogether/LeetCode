/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

二分查找

*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1,m;
        while(l<r)
        {
            m=(l+r)/2;
            if(nums[m]<target)l=m+1;
            else if(nums[m]>target)r=m-1;
            else return m;
        }
        return nums[l]<target?l+1:l;
    }
}

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length-1,m;
        while(l<=r)
        {
            m=(l+r)/2;
            if(nums[m]<target)l=m+1;
            else if(nums[m]>target)r=m-1;
            else return m;
        }
        return l;
    }
}