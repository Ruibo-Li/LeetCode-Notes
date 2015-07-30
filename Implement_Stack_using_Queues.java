class MyStack {
    LinkedList<Integer> q1 = new LinkedList<Integer>();
    LinkedList<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        while(!q1.isEmpty())
            q2.add(q1.removeFirst());
        q1.add(x);
        while(!q2.isEmpty())
            q1.add(q2.removeFirst());
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!q1.isEmpty())
            q1.removeFirst();
    }

    // Get the top element.
    public int top() {
        return q1.get(0);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}