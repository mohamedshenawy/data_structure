package data.structure;

import java.util.Arrays;



public class PriorityQueue {
    private int [] arr;
    private int count;
    
    public PriorityQueue(int size){
        arr = new int [size];
    }
    
    public void add(int item){
        if(isFull())
            throw new IllegalStateException();
        
        
        int i = arrange(item);
        arr[i] = item;
        count++;
    }
    
    private int arrange(int item){
        int i;
        for (i = count-1 ; i >= 0; i--) {
            if(arr[i]>item){
                arr[i+1] = arr[i];
            }else{
                break;
            }
        }
        return i+1;
    }
    
    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        return arr[--count];
    }
    
    public boolean isFull(){
        return count == arr.length;
    }
    
    public boolean isEmpty(){
        return count == 0;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}
