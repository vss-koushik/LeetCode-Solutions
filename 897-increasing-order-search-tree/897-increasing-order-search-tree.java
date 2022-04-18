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
    private TreeNode cur = null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        cur = dummy;
        inOrder(root);
        return dummy.right;
    }
    
    private void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        root.left = null;
        cur.right = root;
        cur = root;
        inOrder(root.right);
    }
}