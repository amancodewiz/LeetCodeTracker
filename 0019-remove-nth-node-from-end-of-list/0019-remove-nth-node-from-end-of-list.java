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
        ListNode fast = head, slow = head; // Step 1: Initialize two pointers
        
        // Step 2: Move 'fast' pointer 'n' steps ahead
        for (int i = 0; i < n; i++) fast = fast.next;

        // If 'fast' becomes null, it means we need to remove the head node
        if (fast == null) return head.next;

        // Step 3: Move 'fast' and 'slow' together until 'fast' reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 4: Remove the Nth node from the end
        slow.next = slow.next.next;

        return head;
    }
}
