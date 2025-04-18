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
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the linked list
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode h2 = slow.next;
        slow.next = null; // Break the list into two halves
        ListNode prev = null, curr = h2, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        h2 = prev; // Head of the reversed second half

        // Step 3: Merge the two halves alternately
        ListNode t1 = head, t2 = h2;
        while (t2 != null) {
            ListNode n1 = t1.next, n2 = t2.next;
            t1.next = t2;
            t2.next = n1;
            t1 = n1;
            t2 = n2;
        }
    }
}