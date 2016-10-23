/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

向右旋转几就相当于将末尾几个移动到前面
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)return head;
        ListNode p=head,tail=head;
        int length=0,position=0;
        while(p!=null)//求长度
        {
            tail=p;
            p=p.next;
            length++;
        }
        if(k>length)k=k%length;
        else if(k==length)return head;
        position=length-k;

        p=head;
        while(--position>0)p=p.next;//寻找head
        
        tail.next=head;
        head=p.next;
        p.next=null;
        return head;
    }
}