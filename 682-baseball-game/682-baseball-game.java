class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for(String op : ops){
            if(op.equals("+")){
                int topVal = stack.pop();
                int nextTop = stack.peek();
                stack.push(topVal);
                stack.push(topVal + nextTop);
            }
            else if(op.equals("D"))
                stack.push(2*stack.peek());
            else if(op.equals("C"))
                stack.pop();
            else
                stack.push(Integer.valueOf(op));
        }
        
        int ans = 0;
        for(int op : stack)
            ans += op;
        return ans;
    }
}