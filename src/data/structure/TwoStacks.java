package data.structure;

import java.util.Arrays;

public class TwoStacks {
    private int [] arr ;
    private int top1;
    private int top2;
    
    public TwoStacks(int size){
        if (size <= 0)
            throw new IllegalArgumentException("capacity must be 1 or greater.");

        arr = new int [size];
        top1 = -1;
        top2 = size;
    }
    
    public void push1(int item){
        if(isFull1())
            throw new IllegalStateException();
        arr[++top1] = item;
    }
    public int pop1(){
        if(isEmpty1())
            throw new IllegalStateException();
        return arr[top1--];
    }
    public boolean isEmpty1(){
        return top1==-1;
    }
    public boolean isFull1(){
        return top1 +1 == top2;
    }
    
    public void push2(int item){
        if(isFull2())
            throw new IllegalStateException();
        arr[--top2] = item;
    }
    public int pop2(){
        if(isEmpty2())
            throw new IllegalStateException();
     return arr[top2++];   
    }
    public boolean isEmpty2(){
        return top2 == arr.length;
    }
    public boolean isFull2(){
        return top2 -1 == top1;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
}
