/*
Implement pow(x, n).

对于n是奇数时，x^n = x^（n/2）*  x^（n/2）* x
对于n是偶数时，x^n = x^（n/2）*  x^（n/2）      
x^（n/2）用一个变量sub记录，x^n = sub * sub * x^(n % 2)  这样 x^（n/2）就计算一次
注意：n有可能是负数  转换为  1.0 / pow(x, -n)   此时-n有可能溢出。用powL(double x,long n)解决。
*/
public class Solution {
    public double myPow(double x, int n) {
        return myPowL(x,n);
    }
    
    public double myPowL(double x,long n)
    {
        if(n<0)return 1.0/myPowL(x,-n);
        else if(n==0) return 1;
        else if(n==1) return x;
        
        double x_n_2=myPowL(x,n/2);
        return x_n_2*x_n_2*myPowL(x,n%2);
    }
}