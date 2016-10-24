/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 扫描链表，将小于x的结点挂在左边的分支上，其他挂在右边的分支上，最后将两个分支合并即可
 */
 
 
public class Solution {
    public ListNode partition(ListNode head, int x) {
     ListNode left=null,right=null,lh=null,rh=null,p=head;
     while(p!=null)
     {
         if(p.val<x)
         {
             if(left==null)
             {
                 left=p;
                 lh=left;
             }
             else 
             {
                 left.next=p;
                 left=left.next;
             }
         }
         else
         {
             if(right==null)
             {
                 right=p;
                 rh=right;
             }
             else 
             {
                 right.next=p;
                 right=right.next;
             }
         }
         p=p.next;
     }
     if(right!=null)right.next=null;
     if(left!=null)left.next=rh;
     else lh=rh;
     return lh; 
    }
}