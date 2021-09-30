package data.structure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DataStructure {

    public static void main(String[] args) {
            StackWithTwoQueues stack = new StackWithTwoQueues();
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);
            stack.push(60);
            stack.push(70);
            stack.pop();
            stack.pop();    
            stack.pop();    
            System.out.println(stack);
            System.out.println(stack.peek());
            System.out.println(stack.size());
    }
}
