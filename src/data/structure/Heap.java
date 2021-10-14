package data.structure;

import java.util.Arrays;

public class Heap {
    public  int [] items;
    public int count;
    
    public Heap(int size){
        items = new int [size];
    }
    
    
    public void insert (int value){
        if(isFull())
            throw new IllegalStateException();
        
        items[count++] =value;
        bubbleUp();
    }
    public boolean isFull(){
        return count == items.length;
    }
    private void bubbleUp(){
        int index = count-1;
        while(index > 0 &&items[index]> items[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private void swap(int first , int second){
        int temp = items[first];
        items[first] = items[second] ;
        items[second] = temp;
    }
    
    
    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        
        int root = items[0];
        items[0] = items[--count];
        
        bubbleDown();
        return root;
    }
    private void bubbleDown(){
        int index = 0;
        while(index<=count && !isValidParent(index)){
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }
    private boolean isValidParent(int index){
        if(!hasLeftChild(index))
            return true;
        
        boolean isValid = items[index] >= leftValue(index);
        
        if(hasRightChild(index))
            isValid &=items[index]>= rightValue(index);
        
        return isValid;
    }
    private int largerChildIndex(int index){
        if(!hasLeftChild(index))
            return index;
        
        if(!hasRightChild(index))
            return leftIndex(index);
        
        return leftValue(index)> rightValue(index)? 
                    leftIndex(index) : rightIndex(index);
    }
    private boolean hasLeftChild(int index){
        return leftIndex(index) <= count;
    }
    private boolean hasRightChild(int index){
        return rightIndex(index) <= count;
    }
    private int leftIndex(int index){
        return index * 2 +1;
    }
    private int leftValue(int index){
        return items[leftIndex(index)];
    }
    private int rightIndex(int index){
        return index * 2 +2;
    }
    private int rightValue(int index){
        return items[rightIndex(index)];
    }
    public boolean isEmpty(){
        return count == 0;
    }
    public int max(){
        if(isEmpty())
            throw new IllegalStateException();
        return items[0];
    }
    
    public boolean isMaxHeap(int [] array){
        return isMaxHeap(array, 0);
    }
    private boolean isMaxHeap(int [] array , int index){
        int lastParentIndex = (array.length-2)/2;
        if(index>lastParentIndex)
            return true;
        
        int leftChildIndex = index *2 -1;
        int rightChildIndex = index *2 -2;
        
        boolean isValidParent = 
                array[index]>= array[leftChildIndex]&&
                array[index]>= array[rightChildIndex];
        
        return isValidParent &&
                isMaxHeap(array, leftChildIndex)&&
                isMaxHeap(array, rightChildIndex);
    }
    
}
