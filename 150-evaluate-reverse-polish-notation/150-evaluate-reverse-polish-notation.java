class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));
    
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i < tokens.length; i++){
            String token = tokens[i];
            if(set.contains(token)){
                int right = stack.pop();
                int left = stack.pop();
                if(token.equals("+")) stack.push(left + right);
                else if(token.equals("-")) stack.push(left - right);
                else if(token.equals("*")) stack.push(left * right);
                // if(token.equals("/")) 
                else stack.push(left / right);
            }
            else stack.push(Integer.parseInt(token));
        }
        
        return stack.pop();
    }
}