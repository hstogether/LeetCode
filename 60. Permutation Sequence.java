/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

/*
共n个数，取按序全排列的第k个
该数的各个位由如下组成：integer[a[1]]integer[a[2]]integer[a[3]]...integer[a[n]]
其中：integer[1...n]=[1...n]
      a[i]=k[i]/(n-i)!+1
      k[i+1]=k[i]%(n-i)!
	  k[1]=k-1
*/
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuffer ret=new StringBuffer();
        int[] mt=new int[n+1];
        Arrays.fill(mt,1);
        for(int i=1;i<=n;i++)mt[i]=mt[i-1]*i;
        List<Integer> inte=new ArrayList<Integer>();
        for(int i=1;i<=n;i++)inte.add(i);
        k=k-1;
        for(int a=0,i=1;i<=n;i++)
        {
            a=k/mt[n-i]+1;
            k=k%mt[n-i];
            ret.append(String.valueOf(inte.remove(a-1)));
        }
        return ret.toString();
    }
}