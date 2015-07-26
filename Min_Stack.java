class MinStack {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> minSt = new Stack<Integer>();
    
    public void push(int x) {
        st.push(x);
        if(minSt.isEmpty()||x<=minSt.peek())
            minSt.push(x);
    }

    public void pop() {
        if(st.isEmpty())
            return;
        int popEle = st.pop();
        if(popEle==minSt.peek())
            minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
