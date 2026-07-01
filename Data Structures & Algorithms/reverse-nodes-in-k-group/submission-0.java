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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;
        while (temp != null) {
            int count = 1;
            ListNode kthNode = temp;
            while (count < k && kthNode.next != null) {
                kthNode = kthNode.next;
                count++;
            }
            if (count < k) {
                if (prevNode != null)
                    prevNode.next = temp;
                break;
            }
            nextNode = kthNode.next;
            kthNode.next = null;
            ListNode reversed = reverseList(temp);
            if (head == temp)
                head = reversed;
            else
                prevNode.next = reversed;
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode front = current.next;
            current.next = prev;
            prev = current;
            current = front;
        }
        return prev;
    }
}
