/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.

这道题的要求是计算大数乘法。其中大数是以字符串的形式表示，任意大，非负，返回结果以字符串形式。

这道题其实就是模拟整数乘法。

假设两个整数的长度分别为了l1和l2，则其最后结果长度为l1+l2（最后有进位）或者l1+l2-1（最后没有有进位）。

因此，可以先用长度为l1+l2的数组记录结果，最后再转成字符串。

进行乘法的时候，先把各个位的相乘结果对应累加起来，即第1个整数的第i位（低位到高位）和第2个整数的第j位（低位到高位）相乘的结果应该存放在数组的i+j位。然后再统一处理进位。

然后再统一处理进位，需要注意的是在计算的时候将结果的地位保存在了数组的低位中。

最后再将数组转成字符串前，需要跳过前面的零。如果结果只有0，则只返回0。

时间复杂度：O(l1l2)（l1和l2分别为两个整数长度）

空间复杂度：O(l1+l2)


*/

public class Solution {
    public String multiply(String num1, String num2) {
        int l1=num1.length();
        int l2=num2.length();
        int[] ret=new int[l1+l2];
        Arrays.fill(ret,0);
        
		//计算乘法（不处理进位）
        for(int i=0;i<l1;i++)
            for(int j=0;j<l2;j++)
                ret[i+j]+=(num1.charAt(l1-1-i)-'0')*(num2.charAt(l2-1-j)-'0');
				
        //处理进位
        for(int i=0,carr=0;i<ret.length;i++)
        {
            int tmp=ret[i]+carr;
            ret[i]=tmp%10;
            carr=tmp/10;
        }
		
        //去除前面的0
        int stidx=-1;
        for(int i=ret.length-1;i>=0;i--)//方向相反
            if(ret[i]!=0){stidx=i;break;}
			
		//返回结果字符串
        if(stidx==-1)return "0";
        else
        {
            StringBuffer rets=new StringBuffer();//方向相反
            for(int i=stidx;i>=0;i--)
                rets.append(ret[i]);
            return new String(rets);
        }
    }
}