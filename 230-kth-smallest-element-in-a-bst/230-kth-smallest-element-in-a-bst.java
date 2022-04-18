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
    private int count = 1;
    private TreeNode ans = null;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        if(ans == null)
            return 0;
        return ans.val;
    }
    
    private void inorder(TreeNode root, int k){
        if(root == null)
            return;
        
        if(root.left != null){
            inorder(root.left, k);
        }
        if(root != null)
            count++;
        
        if(count - 1 == k){
            ans = root;
            return;
        }
        if(root.right != null){
            inorder(root.right, k);
        }
        
    }
}