/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int count = 0; // counter to track the number of nodes visited
    private int result = -1; // to store the kth smallest element

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        // Base case: If node is null, return
        if (node == null) {
            return;
        }

        // Traverse the left subtree first (smallest values first)
        inorder(node.left, k);

        // After visiting left, visit current node
        count++;
        if (count == k) {
            result = node.val;
            return; // We found our answer, no need to continue
        }

        // Traverse the right subtree
        inorder(node.right, k);
    }
}
