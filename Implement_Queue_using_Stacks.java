class MyQueue {
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> st;
        while(!st1.isEmpty())
            st2.push(st1.pop());
        st1.push(x);
        while(!st2.isEmpty())
            st1.push(st2.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!st1.isEmpty())
            st1.pop();
    }

    // Get the front element.
    public int peek() {
        return st1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return st1.isEmpty();
    }
}