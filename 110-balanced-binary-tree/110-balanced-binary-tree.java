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
    public boolean isBalanced(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        return height(root) != -1;
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        
        int left = 1 + height(root.left);
        int right = 1 + height(root.right);
        if(left == 0 || right == 0) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right);
    }
}