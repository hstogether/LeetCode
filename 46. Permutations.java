/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

/*
插空法，顺序未必完全一致
例如：1，2，3
ini：[]
插1：[1]
插2：[2,1][1,2]
插3：[3,2,1][2,3,1][2,1,3][3,1,2][1,3,2][1,2,3]
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();//双向队列
    res.add(new ArrayList<Integer>());
    
    for (int n:nums) 
    {
        int size=res.size();
        System.out.println("res.size()="+size);
        while(size-->0) 
        {
            List<Integer>r=res.removeFirst();
            System.out.println("res.removeFirst()"+r);
            for (int i=0;i<=r.size();i++) 
            {
                List<Integer>t=new ArrayList<Integer>(r);
                t.add(i,n);
                res.addLast(t);
                System.out.println("res="+res);
            }
        }
    }
    return res;
    }
}
/*
Run Code Result: ×

Your input

[1,2,3]
Your stdout

res.size()=1
res.removeFirst()[]
res=[[1]]
res.size()=1
res.removeFirst()[1]
res=[[2, 1]]
res=[[2, 1], [1, 2]]
res.size()=2
res.removeFirst()[2, 1]
res=[[1, 2], [3, 2, 1]]
res=[[1, 2], [3, 2, 1], [2, 3, 1]]
res=[[1, 2], [3, 2, 1], [2, 3, 1], [2, 1, 3]]
res.removeFirst()[1, 2]
res=[[3, 2, 1], [2, 3, 1], [2, 1, 3], [3, 1, 2]]
res=[[3, 2, 1], [2, 3, 1], [2, 1, 3], [3, 1, 2], [1, 3, 2]]
res=[[3, 2, 1], [2, 3, 1], [2, 1, 3], [3, 1, 2], [1, 3, 2], [1, 2, 3]]
Your answer

[[3,2,1],[2,3,1],[2,1,3],[3,1,2],[1,3,2],[1,2,3]]
Expected answer

[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/