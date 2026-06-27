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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode itr1 = l1;
        ListNode itr2 = l2;
        ListNode prev = null;
        boolean carryForward = false;
        while (itr1 != null || itr2 != null) {
            int no1 = itr1 != null ? itr1.val : 0;
            int no2 = itr2 != null ? itr2.val : 0;
            int res = no1 + no2;
            if (carryForward)
                res++;
            carryForward = res >= 10;
            ListNode newNode = new ListNode(res % 10);
            if (prev == null)
                newHead = newNode;
            else
                prev.next = newNode;
            prev = newNode;
            if (itr1 != null)
                itr1 = itr1.next;
            if (itr2 != null)
                itr2 = itr2.next;
        }
        if (carryForward)
            prev.next = new ListNode(1);
        return newHead;
    }
}
