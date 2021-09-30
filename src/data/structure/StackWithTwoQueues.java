package data.structure;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue <Integer> queue1 = new ArrayDeque<>();
    private Queue <Integer> queue2 = new ArrayDeque<>();
    private int count ;
    private int top;
    
    public void push (int item){ // o(1)
        queue1.add(item);
        top = item;
        count ++;
    }
    public int pop(){ // o(n)
        if(isEmpty())
            throw new IllegalStateException();
        
        for (int i = 0; i < count-1; i++) {
            queue2.add(queue1.remove());
            
            if(i<count-2)
                top = queue1.peek();
        }
        
        count --;
        
        int value = queue1.remove(); // pop
        
        for (int i = 0; i < count; i++) {
            queue1.add(queue2.remove());
        }
        
        return value;
    }
    
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        return top;
    }
    
    public boolean isEmpty(){
        return count == 0; 
    }
    public int size(){
        return count;
    }
    
    @Override
    public String toString(){
        return queue1.toString();
    }
}
