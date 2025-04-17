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
        int length = 0;//actual length
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;//counting length of nodes
        }
        int indexNodeBeforDel = length - n;
        ListNode temp2 = head;
        int start = 1;
        if (indexNodeBeforDel == 0) {
            return head.next;
        }
        while (start != indexNodeBeforDel) {
            temp2 = temp2.next;
            start++;
        }
        temp2.next = temp2.next.next;
        return head;

    }
}