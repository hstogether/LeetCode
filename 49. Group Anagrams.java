/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
*/

/*
Accepted
用HashMap，原理相同
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> ret=new HashMap<String,List<String>>();
        for(String s:strs)
        {
            char[] cs=s.toCharArray();
            Arrays.sort(cs);
            String temp=String.valueOf(cs);
            
            if(ret.containsKey(temp))
            {
                List<String> rm=ret.remove(temp);
                rm.add(s);
                ret.put(temp,rm);
            }
            else
            {
                List<String> rt=new ArrayList<String>();
                rt.add(s);
                ret.put(temp,rt);
            }
        }
        List<List<String>> res=new ArrayList<List<String>>();
        for(List<String> value:ret.values()) res.add(value);
        return res;
    }
}


/*
一个有序表和一个结果表。有序表保存相同字母的值。
Time Limit Exceeded
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret=new ArrayList<List<String>>();
        List<String> order=new ArrayList<String>();
        for(String s:strs)
        {
            char[] cs=s.toCharArray();
            Arrays.sort(cs);
            String temp=String.valueOf(cs);
            int index=order.indexOf(temp);
            
            if(index<0)
            {
                order.add(temp);
                List<String> rt=new ArrayList<String>();
                rt.add(s);
                ret.add(rt);
            }
            else
            {
                List<String> rm=ret.get(index);
                rm.add(s);
                ret.set(index,rm);
            }
        }
        return ret;
    }
}