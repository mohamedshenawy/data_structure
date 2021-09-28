package data.structure;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Linkedlist {
    
    private class Node {
    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }

    private Node first;
    private Node last;
    private int size ;

    //add last
    public void addLast(int item){
        Node node = new Node(item);
        //check linked list empty
        if (isEmpty()) {
            first  = last = node;
        }else{
            last.next = node;
            last = node;
        }
        size ++;
    }
    //add first
    public void addFirst(int item){
        Node node  = new Node(item);
        if(isEmpty()){
            first = last = node;
        }else{
            first.next = node;
            first= node;
        }
        size ++;
    }
    
    //delete last
    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
        }else{
            Node previous = getPrevious(last);
        last = previous;
        last.next = null;
        }
        size --;
    }
    private Node getPrevious(Node node){
        for (Node i = first ;i != null;i = i.next){
            if(i.next == node)
                return i;
        }
        return null;
    }
    
    //delete first
    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
        }else{
            Node second = first.next;
            first.next = null;
            first = second;
        }
        
        size --;
    }
    
    //contains
    public boolean contains(int item){
        return indexOf(item)!= -1;
    }
    
    //indexof
    public int indexOf(int item){
        int index = 0;
        for(Node i = first; i!=null;i = i.next){
            if(i.value == item)
                return index;
            index++;
        }
        return -1;
    }
    
    //size
    public int size(){
        return size;
    }
    
    //convert linked list to array
    public int [] toArray(){
        int [] arr = new int[size];
        int index = 0;
        for (Node i = first; i!=null ;i = i.next){
            arr[index++] = i.value;
        }
        return arr;
    }
    //reversing linked list inplace
    public void reverse(){
        if(isEmpty())
            return;
        Node current = last;
        for (int i = 0; i < size; i++) {
            if (current ==first)
                first.next = null;

            // [10 <- 20 <-30]
            current.next = getPrevious(current);
            current = getPrevious(current);
        }
        first = last;
        last = first;
        
    }
    
    //get kth node form the end in one pass
    public int getKthNodeFromEnd(int k){
        if(isEmpty())
            throw new IllegalStateException();
        
        Node a = first;
        Node b = first;
        for(int i = 0 ; i < k-1 ; i++ ){
            b = b.next;
            if(b == null)
                throw new IllegalArgumentException();
        }
        while (b != last) {            
            a = a.next;
            b = b.next;
        }
        return a.value;
    }
    
    //get the middle of linked list on one pass
    public void printMiddle(){
        Node a = first;
        Node b = first;
        while (b!=last && b.next != last) {            
            b = b.next.next;
            a = a.next;
        }
        
        if (b == last) {
            System.out.println(a.value);
        }else{
            System.out.println(a.value + " , " + a.next.value);
        }
    }
    
    
    private boolean isEmpty(){
        return first == null;
    }
}
