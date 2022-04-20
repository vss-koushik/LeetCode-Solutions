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
class BSTIterator {
    private List<Integer> mList = new ArrayList<Integer>();
    private int index = 0;
    public BSTIterator(TreeNode root) {
        inorder(root, mList);    
    }
    
    public int next() {
        return mList.get(index++);
    }
    
    public boolean hasNext() {
        return index < mList.size();
    }
    
    private void inorder(TreeNode root , List<Integer> mList){
        if(root == null)
            return;
        inorder(root.left, mList);
        mList.add(root.val);
        inorder(root.right, mList);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */