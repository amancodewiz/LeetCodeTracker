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
        ListNode temp = head;  // Pointer to traverse the list
        ListNode prev = null;  // Tracks previous node, initially NULL

        while (temp != null) {  // Loop until we reach the end of the list
            ListNode front = temp.next;  // Store next node before breaking the link
            temp.next = prev;  // Reverse the link: point temp to previous node
            prev = temp;  // Move prev forward (temp is now the previous node)
            temp = front;  // Move temp forward (front is now the new current node)
        }

        return prev;  // prev is the new head of the reversed linked list
    }
}
//====================================================================================

/* Using Recursion
class Solution{
    public static Node reverseLinkedList(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead=reverseLinkedList(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}
*/