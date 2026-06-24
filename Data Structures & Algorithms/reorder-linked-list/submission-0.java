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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondListPtr = slow.next;
        ListNode prev = null;
        ListNode current = secondListPtr;
        slow.next = null;
        while (current != null) {
            ListNode forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        secondListPtr = prev;
        ListNode firstListPtr = head;
        ListNode temp1, temp2;
        while (secondListPtr != null) {
            temp1 = firstListPtr.next;
            temp2 = secondListPtr.next;
            firstListPtr.next = secondListPtr;
            secondListPtr.next = temp1;
            firstListPtr = temp1;
            secondListPtr = temp2;
        }
    }
}
