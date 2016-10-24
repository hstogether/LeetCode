<<<<<<< HEAD
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
*/

/*
steps:目前为止的jump数

last:从A[0]进行steps次jump之后达到的最大范围

reach:从0~i这i+1个元素中能达到的最大范围

当last < i，说明steps次jump已经不足以覆盖当前第i个元素，因此需要增加一次jump，使之达到

记录的reach。

*/
public class Solution {
    public int jump(int[] nums) {
        int reach=0,last=0,steps=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>last)
            {
                steps++;
                last=reach;
            }
            reach=Math.max(reach,nums[i]+i);
        }
        
        return steps;
    }
}

/*
递归栈溢出
Line 11: java.lang.StackOverflowError
[5000个1]

*/
public class Solution {
    int min=Integer.MAX_VALUE;
    public int jump(int[] nums) {
        return jumpOne(nums,0);
    }
    
    public int jumpOne(int[] nums,int cur)
    {
        if(cur>=nums.length)return min;
        else if(cur==nums.length-1)return Math.min(cur,min);
        return Math.min(min,jumpOne(nums,cur+1));
    }
=======
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
*/

/*
steps:目前为止的jump数

last:从A[0]进行steps次jump之后达到的最大范围

reach:从0~i这i+1个元素中能达到的最大范围

当last < i，说明steps次jump已经不足以覆盖当前第i个元素，因此需要增加一次jump，使之达到

记录的reach。

*/
public class Solution {
    public int jump(int[] nums) {
        int reach=0,last=0,steps=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>last)
            {
                steps++;
                last=reach;
            }
            reach=Math.max(reach,nums[i]+i);
        }
        
        return steps;
    }
}

/*
递归栈溢出
Line 11: java.lang.StackOverflowError
[5000个1]

*/
public class Solution {
    int min=Integer.MAX_VALUE;
    public int jump(int[] nums) {
        return jumpOne(nums,0);
    }
    
    public int jumpOne(int[] nums,int cur)
    {
        if(cur>=nums.length)return min;
        else if(cur==nums.length-1)return Math.min(cur,min);
        return Math.min(min,jumpOne(nums,cur+1));
    }
>>>>>>> ed27091b159975f65e5dcd56c64b08429e53bc31
}