/*You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
	private ListNode ln, lm, first;		//lm is the previos node. ln is current node. lm->ln
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int cout = 0;
        first = null;
        lm =null;
    	
    	while (l1 != null && l2 != null) { 
    	    ln = new ListNode((l1.val + l2.val + cout) % 10);
    	    cout = (l1.val + l2.val + cout) / 10;
    	    
    	    if(first == null) {
    	        first = ln;
    	        lm = ln;
    	    } else {
    	        lm.next = ln;
    	        lm = ln;
    	    }
    	    
    	    l1 = l1.next;
    	    l2 = l2.next;
    	}
    	
    	while (l1 != null && l2 == null) {
    		ln = new ListNode((l1.val + cout) % 10);
    		cout = (l1.val + cout) / 10;
    		lm.next = ln;
    		lm = ln;
    		
    		l1 = l1.next;
    	}
    	while (l1 == null && l2 != null) {
    		ln = new ListNode((l2.val + cout) % 10);
    		cout = (l2.val + cout) / 10;
    		lm.next = ln;
    		lm = ln;
    		
    		l2 = l2.next;
    	}
    	if (cout != 0) {
    		ln = new ListNode(cout);
    		lm.next = ln;
    	}
    	return first;
    }
}
