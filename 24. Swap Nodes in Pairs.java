<<<<<<< HEAD
/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
用递归
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null|| head.next==null)return head;
        
        ListNode tmp=head.next;
        head.next=swapPairs(tmp.next);
        tmp.next=head;
        
        return tmp;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null)return head;
        ListNode p=head;
        ListNode q=p.next;
        while(q!=null)
        {
            int t=p.val;
            p.val=q.val;
            q.val=t;
            p=q.next;
            q=p==null?null:p.next;
        }
        return head;
    }
=======
/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
用递归
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null|| head.next==null)return head;
        
        ListNode tmp=head.next;
        head.next=swapPairs(tmp.next);
        tmp.next=head;
        
        return tmp;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null)return head;
        ListNode p=head;
        ListNode q=p.next;
        while(q!=null)
        {
            int t=p.val;
            p.val=q.val;
            q.val=t;
            p=q.next;
            q=p==null?null:p.next;
        }
        return head;
    }
>>>>>>> ed27091b159975f65e5dcd56c64b08429e53bc31
}