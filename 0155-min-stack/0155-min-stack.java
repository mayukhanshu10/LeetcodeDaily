class MinStack {
    
    static class Pair{
        int val;
        int min;
        Pair(int x,int y){
            this.val=x;
            this.min=y;
        }
    }
    
    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.size()==0){
            st.push(new Pair(val,val));
            return;
        }
        
        int min = Math.min(val,st.peek().min);
        st.push(new Pair(val,min));
        return;
        
    }
    
    public void pop() {
        if(st.size()>0){
            st.pop();
        }
        return;
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        
        return st.peek().min;
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