/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

把不同的数移动到数组的前面即可
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        int p=0,q=1;
        while(p<q&&q<nums.length)
        {
            if(nums[p]<nums[q])
            {
                nums[p+1]=nums[q];
                p++;
                q++;
            }
            else q++;
        }
        return p+1;
    }
}