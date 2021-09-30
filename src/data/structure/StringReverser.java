package data.structure;

import java.util.Stack;

public class StringReverser {
public StringBuffer  reverse(String input){
    if(input == null)
        throw new IllegalArgumentException();
    
    Stack <Character> stack = new Stack<>();
    for(char ch : input.toCharArray())
        stack.push(ch);
    
    StringBuffer reverced = new StringBuffer();
    while (!stack.empty()) {        
        reverced.append(stack.pop());
    }
    return reverced;
}    
}
