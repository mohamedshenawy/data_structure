    
package data.structure;

import java.util.Arrays;

public class ArrayQueue {
        private int [] items;
        private int front = 0;
        private int rear ;
        private int count;
        
        public ArrayQueue(int size){
            items = new int[size];
        }

        public void enqueue(int item){
            if(isFull())
                throw new IllegalStateException();

            items[rear] = item;
            rear = (rear+1)%items.length; // circular array
            count++;        
        }

        public int dequeue(){
            //[1,f2,3,4,5]
            if (isEmpty())
                throw new IllegalStateException();

            int item = items[front];
            items[front] =0;
            front = (front+1)%items.length;
            count--;
            return item;
        }

        public int peek(){
            return items[front];
        }

        public boolean isEmpty(){
            return count == 0 ;
        }
        public boolean isFull(){
            return count == items.length;
        }
        @Override
        public String toString(){
            return Arrays.toString(items);
        }
        
        
}
