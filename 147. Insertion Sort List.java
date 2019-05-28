/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode helper = new ListNode(0);
        ListNode tempHelper = helper;

        while (head != null) {

            ListNode next = head.next;
            System.out.println(head.val);

            while (tempHelper.next != null && head.val > tempHelper.next.val) {
                // System.out.println(tempHelper.next.val);
                tempHelper = tempHelper.next;
            }

            ListNode temp = tempHelper.next;
            tempHelper.next = head;
            // if (head.next != null) System.out.println(head.next.val);
            tempHelper.next.next = temp;
            // if (head.next == null) System.out.println("null");
            tempHelper = helper;
            head = next;
        }
        return helper.next;
    }
}
