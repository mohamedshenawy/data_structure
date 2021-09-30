package data.structure;

import java.util.ArrayList;


public class LinkedListQueue {
    private class Node {
        private int value;
        private Node next;
        
        public Node (int value){
            this.value  = value;
        }
    }
    
    private Node first;
    private Node last;
    private int count;
    
    // o(1)
    public void enqueue(int item){
        Node node  = new Node(item);
        
        if(isEmpty()){
            first = last = node;
        }else{
            last.next = node;
            last = node;
        }
        count++;
    }
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();
        
        int value = first.value;
        first  = first.next;
        count --;
        
        return value;
    }
    
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        return first.value;
    }
    
    public boolean isEmpty(){
        return count ==0 ;
    }
    
    public int size(){
        return count;
    }
    
    @Override
    public String toString(){
        ArrayList<Integer> list = new ArrayList<>();
        
        Node current = first;
        while(current != null){
            list.add(current.value);
            current = current.next;
        }
        return list.toString();
    }
}
