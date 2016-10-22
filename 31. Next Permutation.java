/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<2) return;
        
        int m,n;
		//寻找递增子序列，m为该序列的起始点，找到的递增子序列为[m,nums.length-1]
        for(m=nums.length-2;m>=0;m--)
            if(nums[m]<nums[m+1])break;
            
        
        if(m<0)//若不存在子升序，则说明当前排列是最大排列，此时i = -1，下一排列即是最小排列，翻转整个序列即可
        {
			//将首尾对应位置换即可
            for(int i=0,j=nums.length-1;i<j;i++,j--)
            {
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
            return;
        }   
        else//找到了子升序
        {
		    //寻找子序列中新的最高位
            for(n=nums.length-1;m<n;n--)
                if(nums[m]<nums[n])break;
            int tmp=nums[m];
            nums[m]=nums[n];
            nums[n]=tmp;
            //剩下的是一个递减序列，反转即可
            for(int i=m+1,j=nums.length-1;i<j;i++,j--)
            {
                tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
            return;
        }
        
    }
}