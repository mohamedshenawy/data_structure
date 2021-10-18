package data.structure;

import java.util.Arrays;
import java.util.List;


public class DataStructure {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("car");
        obj.insert("care");
        obj.insert("card");
        obj.insert("carefull");
        obj.insert("egg");
        List<String> word = obj.findWords("care");
        System.out.println(word);
        
    }
    
}
