/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

/*Accepted
假设把A[i]之前的连续段叫做sum。可以很容易想到:
1. 如果sum>=0，就可以和A[i]拼接在一起构成新的sum'。因为不管A[i]多大，加上一个正数总会更大，这样形成一个新
   的candidate。
2. 反之，如果sum<0，就没必要和A[I]拼接在一起了。因为不管A[i]多小，加上一个负数总会更小。此时由于题目要求数
   组连续，所以没法保留原sum，所以只能让sum等于从A[i]开始的新的一段数了，这一段数字形成新的candidate。
3. 如果每次得到新的candidate都和全局的max_sum进行比较，那么必然能找到最大的max sum subarray.
在循环过程中，用max_sum记录历史最大的值。从A[0]到A[n-1]一步一步地进行。
*/
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum=Integer.MIN_VALUE;
        int max=sum;
        
        for(int i=0;i<nums.length;i++)
        {
            if(sum>=0)sum+=nums[i];
            else sum=nums[i];
            
            if(sum>max)max=sum;
        }
        return max;
    }
}


/*Time Limit Exceeded*/
public class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int[] res=new int[nums.length];
        Arrays.fill(res,0);
        
        for(int l=1;l<=nums.length;l++)
            for(int i=0;i<=nums.length-l;i++)
            {
                res[i]+=nums[i+l-1];
                max=Math.max(max,res[i]);                
            }
        return max;
    }
}