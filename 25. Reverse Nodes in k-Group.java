/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5


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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextHead=head;
        int curn=0;
		//get a k-nodes group
        while(nextHead!=null&&curn<k)
        {
            nextHead=nextHead.next;
            curn++;
        }
        
        if(curn==k)
        {
			//reverse others
            nextHead=reverseKGroup(nextHead,k);
			//reverse current k-nodes group
            while(k>0)//k times 
            {
                ListNode tmp=head.next;
                head.next=nextHead;
                nextHead=head;
                head=tmp;
                k--;
            }
            head=nextHead;
        }
        return head;
    }
}