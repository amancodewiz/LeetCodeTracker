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
    public boolean isValidBST(TreeNode root) {
        // Start recursion with the full range of allowed values
        // Initially, a node can be between -infinity and +infinity
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function to validate each subtree
    private boolean validate(TreeNode root, long min, long max) {
        // Base case: An empty tree or empty node is always a valid BST
        if (root == null) {
            return true;
        }

        // Current node must be greater than min and less than max
        if (root.val <= min || root.val >= max) {
            return false; // Violates the BST property
        }

        // Recursively validate:
        // 1. Left subtree → node values must be less than current node value
        // 2. Right subtree → node values must be greater than current node value
        return validate(root.left, min, root.val) && 
               validate(root.right, root.val, max);
    }
}
