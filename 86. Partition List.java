/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode one = new ListNode(0);
        ListNode tempOne = one;
        ListNode two = new ListNode(0);
        ListNode tempTwo = two;

        while (head != null) {
            if (head.val < x) {
                one.next = head;
                one = one.next;
            } else {
                two.next = head;
                two = two.next;
            }
            head = head.next;
            // System.out.println("one:" + one.val);
            // System.out.println("two:" + two.val);
        }

        two.next = null;
        one.next = tempTwo.next;

        return tempOne.next;
    }
}
