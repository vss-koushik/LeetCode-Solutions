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
    public boolean checkTree(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return root.val == 0;
        if(root.left == null)
            return root.val == root.right.val;
        if(root.right == null)
            return root.val == root.left.val;
        return root.val == (root.left.val + root.right.val);
    }
}