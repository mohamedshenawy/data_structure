package data.structure;

public class MinHeap {
    private class Node{
        private int key;
        private String value;
        
        public Node(int key , String value){
            this.key = key;
            this.value = value;
        }
    }
    
    private Node [] items;
    int size = 0;
    
    public MinHeap(int capacity){
        items = new Node[capacity];
    }
    
    //insert
    public void insert (int key , String value){
        if(isFull())
            throw new IllegalStateException();
        
        items[size++] = new Node(key , value);
        
        bubbleUp();
    }
    
    private void bubbleUp(){
        int index = size -1;
        while(index<items.length && items[index].key < parentKey(index) ){
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }
    
    private void swap(int first , int second){
        Node temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
    
    private int parentIndex(int index){
        return (index-1)/2;
    }
    
    private int parentKey(int index){
        return items[parentIndex(index)].key;
    }
    
    private int leftChildIndex(int index){
        return index * 2 -1;
    }
    
    private int leftChildKey(int index){
        return items[leftChildIndex(index)].key;
    }
    
    private int rightChildIndex(int index){
        return index * 2 -2;
    }
    
    private int rightChildKey(int index){
        return items[rightChildIndex(index)].key;
    }
    
    public boolean isFull(){
        return size == items.length;
    }
    
    
    //delete (error)
    public String remove() {
        if (isEmpty())
            throw new IllegalStateException();

        String root = items[0].value;
        items[0] = items[--size];

        bubbleDown();

        return root;
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = smallerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    

    private int smallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChildKey(index) < rightChildKey(index)) ?
                leftChildIndex(index) :
                rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        if (hasRightChild(index))
            return items[index].key <= rightChildKey(index);
        else
            return items[index].key <= leftChildKey(index);
       
    }

    
    
    private boolean isEmpty(){
        return size == 0;
    }
}
