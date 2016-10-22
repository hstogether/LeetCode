/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
//用set去重即可
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> ret=new LinkedList<List<Integer>>();
        ret.addLast(new ArrayList<Integer>());
        
        for(int n:nums)
        {
            int size=ret.size();
            while(size-->0)
            {
                List<Integer> entry=ret.removeFirst();
                for(int i=0;i<=entry.size();i++)
                {
                    List<Integer> tmp=new ArrayList<Integer>(entry);
                    tmp.add(i,n);
                    ret.addLast(tmp);
                }
            }
        }
        return new ArrayList<List<Integer>>(new HashSet<List<Integer>>(ret));
    }
}