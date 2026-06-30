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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSorted(0, lists.length - 1, lists);
    }
    public ListNode mergeSorted(int low, int high, ListNode[] lists) {
        if (low == high)
            return lists[low];
        if (low < high) {
            int mid = (low + high) / 2;
            ListNode leftHalf = mergeSorted(low, mid, lists);
            ListNode rightHalf = mergeSorted(mid + 1, high, lists);
            return mergeTwoLists(leftHalf, rightHalf);
        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        if (list1 != null)
            prev.next = list1;
        if (list2 != null)
            prev.next = list2;
        return dummy.next;
    }
}
