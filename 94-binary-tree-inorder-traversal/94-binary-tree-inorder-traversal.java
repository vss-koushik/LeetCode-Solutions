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
    private List<Integer> list = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }
    
    private void helper(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}