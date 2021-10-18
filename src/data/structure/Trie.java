package data.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class Node{
        private char value;
        private HashMap<Character , Node> children = new HashMap<>();
        private boolean isEndOfWord;
        
        public Node(char value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "value = " + value;
        }
        
        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }
        public void addChild(char ch){
            children.put(ch , new Node(ch));
        }
        public Node getChild(char ch){
            return children.get(ch);
        }
        public Node [] getChildren(){
            return children.values().toArray(new Node[0]);
        }
        public boolean hasChildern(){
            return !children.isEmpty();
        }
        public void removeChild(char ch){
            children.remove(ch);
        }
    }
    
    private Node root = new Node(' ');
    
    public void insert (String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }
    
    public boolean contains(String word){
        if(word == null)
            return false;
        
        Node current = root;
        for(char ch : word.toCharArray()){
            if(!current.hasChild(ch))
                return false;
            
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }
    
    public void traverse(){
        traverse(root);
    } 
    private void traverse(Node root){
        // pre order 
        System.out.println(root.value);
        
        for(Node child : root.getChildren())
            traverse(child);
        
        // post-order
        //for(Node child : root.getChildren())
            //traverse(child);
        
        //System.out.println(root.value);
        
    }
    public void delete(String word){
        if(word == null)
            return;
        
        delete(root , word , 0);
    }
    private void delete(Node root , String word , int index){
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }
        
        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if(child == null)
            return;
        
        delete(child , word , index+1);
        
        if(!child.hasChildern() && !child.isEndOfWord)
            root.removeChild(ch);
            
    }
    
    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        Node lastNode = findLastNode(prefix);
        findWords(lastNode , prefix , words);
        return words;
    }
    private void findWords(Node root , String prefix , List<String>words){
        if(root == null)
            return;
        
        if(root.isEndOfWord)
            words.add(prefix);
        
        for(Node child : root.getChildren())
            findWords(child, prefix + child.value, words);
    }
    private Node findLastNode(String prefix){
        if(prefix == null)
            return null;
        
        Node current = root;
        for (char ch : prefix.toCharArray()){
            Node child = current.getChild(ch);
            if(child == null)
                return null;
            
            current = child;
        }
        return current;
    }
    
    public boolean containsRecursive(String word){
        if(word == null)
            return false;
        
        return containsRecursive(root, word, 0);
    }
    private boolean containsRecursive(Node root , String word , int index){
        if(index == word.length()) //base condition
            return root.isEndOfWord;
        
        if(root == null)
            return false;
        
        char ch  = word.charAt(index);
        Node child = root.getChild(ch);
        if(child == null)
            return false;
        
        return containsRecursive(root, word, index+1);
    }
    
    public int countWords(){
        return countWords(root);
    }
    private int countWords(Node root ){
        int count = 0;
        if(root.isEndOfWord)
            return count ++;
        
        for(Node child : root.getChildren())
            count+=countWords(child);
        
        return count;
    }
    
    public String longestCommonPrefix(String [] words){
        if(words == null)
            return "";
        
        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);
        
        StringBuffer prefix = new StringBuffer();
        int maxChars = getShortest(words).length();
        Node current = trie.root;
        while(prefix.length()<maxChars){
            Node [] children = current.getChildren();
            if(children.length !=1)
                break;
            current = children[0];
            prefix.append(current.value);
        }
        return prefix.toString();
    }
    private static String getShortest(String[] words) {
    if (words == null || words.length == 0)
      return "";

    String shortest = words[0];
    for (int i = 1; i < words.length; i++) {
      if (words[i].length() < shortest.length())
        shortest = words[i];
    }

    return shortest;
  }
    
}
