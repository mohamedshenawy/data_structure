package data.structure;

public class minStack {
    private Stack stack = new Stack();
    private Stack minStack = new Stack();
    
    public void push(int item){
        stack.push(item);
        
        if(minStack.isEmpty())
            minStack.push(item);
        
        else if(item < minStack.peek())
            minStack.push(item);
    }
    
    public int pop(){
        if(stack.isEmpty())
            throw new IllegalStateException();
        return stack.pop();
    }
    
    public int min(){
        return minStack.peek();
    }
}
