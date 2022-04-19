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
    private TreeNode pre;// previous node
    private TreeNode first;// first wrong node
    private TreeNode second;// second wrong node

    public void recoverTree(TreeNode root) {
        // recursive inorder traversal
        inorder(root);

        // Swap the values of two nodes
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    // recursive inorder traversal
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        // Traverse the left child node
        inorder(root.left);

        if (first == null && pre != null && pre.val > root.val) {
            first = pre;
        }
        if (first != null && pre.val > root.val) {
            second = root;
        }
        pre = root;

        // Traverse the right child node
        inorder(root.right);
    }
}