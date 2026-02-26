class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    int pee = 0;

    public MyQueue() {

    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            pee = x;
        } else {
            stack.push(x);
        }
    }

    public int pop() {
        int size = stack.size();
        for (int i = 0; i < size - 1; i++) {
            temp.push(stack.pop());
        }
        int remove = stack.pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return remove;
    }

    public int peek() {
        return pee;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */