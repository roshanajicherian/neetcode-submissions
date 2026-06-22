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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return mergeTwoLists(list2, list1);
        ListNode itr1 = list1;
        ListNode itr2 = list2;
        ListNode itr3 = null;
        ListNode newHead = null;
        while (itr1 != null) {
            if (itr2 == null || itr1.val <= itr2.val) {
                ListNode temp = new ListNode(itr1.val,null);
                if (itr3 == null) {
                    itr3 = temp;
                    newHead = itr3;
                } else {
                    itr3.next = temp;
                    itr3 = temp;
                }
                itr1 = itr1.next;
            } else {
                ListNode temp = new ListNode(itr2.val,null);
                if (itr3 == null) {
                    itr3 = temp;
                    newHead = itr3;
                } else {
                    itr3.next = temp;
                    itr3 = temp;
                }
                itr2 = itr2.next;
            }
        }
        while (itr2 != null) {
            ListNode temp = new ListNode(itr2.val,null);
            itr3.next = temp;
            itr3 = temp;
            itr2 = itr2.next;
        }
        return newHead; 
    }
}