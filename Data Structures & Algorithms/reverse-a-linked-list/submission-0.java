/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode temp1 = head;
        ListNode iter = head.next;
        head.next = null;
        while (iter != null) {
            ListNode temp2 = iter.next;
            iter.next = temp1;
            temp1 = iter;
            if (temp2 == null) {
                head = iter;
            }
            iter = temp2;
        }
        return head;
    }
}
