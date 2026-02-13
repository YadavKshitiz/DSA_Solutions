class MinStack {
Stack<Integer> stack=new Stack<>();
Stack<Integer> minStack=new Stack<>();

    public MinStack() {
        // MinStack obj = new MinStack();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else{
            int mini;
            mini=Math.min(minStack.peek(),val);
            minStack.push(mini);
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        int para1=stack.peek();
        return para1;
    }
    
    public int getMin() {
        int para2=minStack.peek();
        return para2;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */