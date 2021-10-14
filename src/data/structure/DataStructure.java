package data.structure;

import java.util.Arrays;


public class DataStructure {

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(6);
        heap.insert(5, "A");
        heap.insert(3, "b");
        heap.insert(8, "c");
        heap.insert(4, "d");
        heap.insert(1, "e");
        heap.insert(2, "f");
        System.out.println(heap.remove());;
    }
    
}
