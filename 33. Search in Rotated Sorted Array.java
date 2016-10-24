<<<<<<< HEAD
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

old position=(new position - rotated length + size ) % size
*/

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length<1)return -1;
        int o1=nums[0];
        Arrays.sort(nums);
        int ret=Arrays.binarySearch(nums,target);
        if(ret<0)return -1;
        
        int n1=Arrays.binarySearch(nums,o1);//移动的距离
        return (ret-n1+nums.length)%nums.length;
    }
}

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length<1)return -1;
        
        int l=0,r=nums.length-1,m=(l+r)/2;
        while(nums[l]>nums[r])
        {
            m=(l+r)/2;
            if(nums[m]==target)return m;
            if(nums[m]>nums[r])l=m+1;
            else if(nums[m]<nums[r])r=m;
            else break;
        }
        //System.out.println(l);
        
        int head=l;
        l=0;
        r=nums.length-1;
        //l=(il+nums.length-head)%nums.length;
        //r=(ir+nums.length-head)%nums.length;
        //System.out.println(l+" "+r);
        while(0<=l&&l<nums.length&&0<=r&&r<nums.length&&nums[(l+head)%nums.length]<=nums[(r+head)%nums.length])
        {
            m=(l+r)/2;
            //System.out.println(m);
            if(nums[(m+head)%nums.length]>target)r=m-1;
            else if(nums[(m+head)%nums.length]<target)l=m+1;
            else return (m+head)%nums.length;
        }
        return -1;
    }
=======
/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

old position=(new position - rotated length + size ) % size
*/

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length<1)return -1;
        int o1=nums[0];
        Arrays.sort(nums);
        int ret=Arrays.binarySearch(nums,target);
        if(ret<0)return -1;
        
        int n1=Arrays.binarySearch(nums,o1);//移动的距离
        return (ret-n1+nums.length)%nums.length;
    }
}

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length<1)return -1;
        
        int l=0,r=nums.length-1,m=(l+r)/2;
        while(nums[l]>nums[r])
        {
            m=(l+r)/2;
            if(nums[m]==target)return m;
            if(nums[m]>nums[r])l=m+1;
            else if(nums[m]<nums[r])r=m;
            else break;
        }
        //System.out.println(l);
        
        int head=l;
        l=0;
        r=nums.length-1;
        //l=(il+nums.length-head)%nums.length;
        //r=(ir+nums.length-head)%nums.length;
        //System.out.println(l+" "+r);
        while(0<=l&&l<nums.length&&0<=r&&r<nums.length&&nums[(l+head)%nums.length]<=nums[(r+head)%nums.length])
        {
            m=(l+r)/2;
            //System.out.println(m);
            if(nums[(m+head)%nums.length]>target)r=m-1;
            else if(nums[(m+head)%nums.length]<target)l=m+1;
            else return (m+head)%nums.length;
        }
        return -1;
    }
>>>>>>> ed27091b159975f65e5dcd56c64b08429e53bc31
}