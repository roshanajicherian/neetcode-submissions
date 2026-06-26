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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode itr = head;
        while (itr != null) {
            size++;
            itr = itr.next;
        }
        int pos = size - n + 1;
        int count = 0;
        ListNode prev = null;
        itr = head;
        while (itr != null) {
            count++;
            if (count == pos) {
                if (prev == null)
                    head = itr.next;
                else
                    prev.next = itr.next;
            }
            prev = itr;
            itr = itr.next;
        }
        return head;
    }
}
