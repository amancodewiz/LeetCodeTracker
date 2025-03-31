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
        // Step 1: Create a dummy node to track the start of the merged list
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        // Step 2: Use two pointers to traverse both lists and merge them
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next; // Move list1 pointer forward
            } else {
                temp.next = list2;
                list2 = list2.next; // Move list2 pointer forward
            }
            temp = temp.next; // Move temp forward
        }

        // Step 3: Attach the remaining elements if any list is not yet fully traversed
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Step 4: Return the merged list, skipping the dummy node
        return dummyNode.next;
    }
}
