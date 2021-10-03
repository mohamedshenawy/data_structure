package data.structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFounder {
    public char firstNonRepeated(String str){
        Map <Character , Integer> map = new HashMap<>();
        char [] chars = str.toCharArray();
        for(char ch : chars){
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count+1);
        }
        
        for(char ch :chars){
            if(map.get(ch)==1)
                return ch;
        }
        return Character.MIN_VALUE;
    }
    
    public char firstRepeated(String str){ // green apple
        Set<Character> set = new HashSet<>();
        char [] chars = str.toCharArray();
        for(char ch : chars){
            if(set.contains(ch) && ch != ' ')
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

}
