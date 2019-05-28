/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) return head;

        int i = 1;

        ListNode prev = null, curr = head, next = null;

        while (i < m) {
            prev = curr;
            next = curr.next;
            curr = next;
            i++;
        }

        ListNode con = prev, tail = next;
        if (con!=null) System.out.println("con " + con.val);
        if (tail!=null) System.out.println("tail " + tail.val);

        while (i <= n) {
            next = curr.next;
            if (i < m) {
                prev = curr;
                curr = curr.next;
            } else {
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            i++;
        }


        if (curr!= null && next != null) curr.next = next.next;
        if (tail != null) tail.next = curr;
        else head.next = curr;
        if (con != null) con.next = prev;
        else return prev;
        return head;
    }
}
