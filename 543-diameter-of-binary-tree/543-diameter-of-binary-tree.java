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
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        int temp = findMax(root);
        return max;
    }
    
    private int findMax(TreeNode root){
        if(root == null)   return 0;
        int lh = findMax(root.left);
        int rh = findMax(root.right);
        
        max = Math.max(max, (lh + rh ));
        
        return Math.max(lh, rh) + 1;
    }
}