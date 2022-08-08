class MyStack {
    private Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q.add(x);
        int len = q.size();
        for(int i = 1; i <= len - 1; i++){
            int ele = q.remove();
            q.add(ele);
        }
    }
    
    public int pop() {
       return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */