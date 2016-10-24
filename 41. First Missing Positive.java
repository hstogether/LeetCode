<<<<<<< HEAD
/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

所以题目是需要你在从1 ~ +∞的范围中，找到没有在输入数组出现过的最小的正数。

然后，这道题基本上不太好想，需要借助bucket sort的思路来考虑。


首先扫描一遍数组，如果某个元素在1~n之间，则把它放入原数组中的i-1位置。最后扫描原数组一遍，找到第一个满足A[i] != i+1的数。
参考文献：http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int l=nums.length;
        for(int i=0;i<l;)
        {
			//nums[i]不等于i+1,并且在[1,nums.length]之间则交换
            if((nums[i]!=i+1)&&(nums[i]>=1)&&(nums[i]<=l)&&(nums[nums[i]-1]!=nums[i])) 
            {
                int tmp=nums[i];
                nums[i]=nums[tmp-1];//这里要用tmp，不要用nums[i]
                nums[tmp-1]=tmp;
            }
            else i++;
        }
        
        for(int i=0;i<l;i++)
            if(nums[i]!=i+1)return i+1;
        return l+1;
    }
=======
/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

所以题目是需要你在从1 ~ +∞的范围中，找到没有在输入数组出现过的最小的正数。

然后，这道题基本上不太好想，需要借助bucket sort的思路来考虑。


首先扫描一遍数组，如果某个元素在1~n之间，则把它放入原数组中的i-1位置。最后扫描原数组一遍，找到第一个满足A[i] != i+1的数。
参考文献：http://www.cnblogs.com/AnnieKim/archive/2013/04/21/3034631.html
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int l=nums.length;
        for(int i=0;i<l;)
        {
			//nums[i]不等于i+1,并且在[1,nums.length]之间则交换
            if((nums[i]!=i+1)&&(nums[i]>=1)&&(nums[i]<=l)&&(nums[nums[i]-1]!=nums[i])) 
            {
                int tmp=nums[i];
                nums[i]=nums[tmp-1];//这里要用tmp，不要用nums[i]
                nums[tmp-1]=tmp;
            }
            else i++;
        }
        
        for(int i=0;i<l;i++)
            if(nums[i]!=i+1)return i+1;
        return l+1;
    }
>>>>>>> ed27091b159975f65e5dcd56c64b08429e53bc31
}