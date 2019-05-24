/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode prev = head, curr = head.next, next = null, prevPrev = null;
        ListNode tempHead = curr;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev.next = next;
            if (prevPrev != null)
                prevPrev.next = curr;
            prevPrev = prev;
            prev = next;
            if (next != null)
                curr = next.next;
            else
                curr = null;
        }

        return tempHead;
    }
}
