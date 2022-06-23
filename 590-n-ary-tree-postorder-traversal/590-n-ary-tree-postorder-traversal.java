/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        if(root == null) return list;
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            list.addFirst(currNode.val);
            List<Node> children = currNode.children;
            for(int i = 0;i < children.size(); i++){
                stack.push(children.get(i));
            }
        }
        return list;
    }
}