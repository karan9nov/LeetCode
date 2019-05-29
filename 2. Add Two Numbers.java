/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode retval = new ListNode(0);
        ListNode retvalHelper = retval;
        int carry = 0;
        while(l1 != null && l2!=null) {
            int val = l1.val + l2.val;
            if (carry != 0) val += carry;
            carry = val/10;
            retval.next = new ListNode(val%10);
            retval = retval.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int val = l1.val + carry;
            carry = val/10;
            retval.next = new ListNode(val%10);
            retval = retval.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int val = l2.val + carry;
            carry = val/10;
            retval.next = new ListNode(val%10);
            retval = retval.next;
            l2 = l2.next;
        }
        
        if (carry != 0)
            retval.next = new ListNode(carry);
        
        return retvalHelper.next;
    }
}