/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

可以用移位操作代替乘除法，a<<=1相当于a*2
减法可代替除法
*/

public class Solution {
    public int divide(int dividend, int divisor) {
        //使用long（or long long）类型防止溢出
        long a=dividend,b=divisor;
		//确定结果的符号
        int f=2;
        if(a<0){a=-a;f-=1;}
        if(b<0){b=-b;f-=1;}

        long ret=0;
		//减法模拟除法
        while(a>=b)
        {
            long c=b;
            for(int i=0;a>=c;i++,c<<=1)//减去b的倍数可以加快运算速度
            {
                a-=c;
                ret+=1<<i;
            }
        }
		
        if(f==1)return (int)-ret;
		//由于负数最小值得绝对值比整数最大值大1，所以当结果为正数的时候需要考虑溢出
        else return (-ret)<=Integer.MIN_VALUE?Integer.MAX_VALUE:(int)ret;
		
		/*
        if(f==1)return (int)-ret;
		//由于负数最小值得绝对值比整数最大值大1，所以当结果为正数的时候需要考虑溢出
        else if((-ret)<=Integer.MIN_VALUE)return Integer.MAX_VALUE;
        else return (int)ret;
		*/
    }
}