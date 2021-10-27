package data.structure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
    private class Node{
        private String label;
        private Node next ;
        
        public Node(String lable){
            this.label = lable;
        }
        
        @Override
        public String toString(){
            return label;
        }
    }
    
    private Map<String , Node> nodes = new HashMap<>();
    //edges for every Node
    private Map<Node , List<Node>> adjacencyList = new HashMap<>();
    
    public void addNode(String label){
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }
    
    public void addEdge(String from , String to){
        Node fromNode = nodes.get(from);
        if(fromNode == null)
            throw new IllegalArgumentException();
        
        Node toNode = nodes.get(to);
        if(toNode == null)
            throw new IllegalArgumentException();
        
        adjacencyList.get(fromNode).add(toNode);
    }
    
    public void print(){
        for(Node source : adjacencyList.keySet()){
            List<Node>targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source +" is connected to " + targets);
        }
    }
    
    public void removeNode(String label){
        Node node  = nodes.get(label);
        if(node == null)
            return ;
        
        for(Node n:adjacencyList.keySet())
            adjacencyList.get(n).remove(node);
        
        adjacencyList.remove(node);
        nodes.remove(node);
    }
    
    public void removeEdge(String from , String to){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        
        if(fromNode == null || toNode == null)
            return;
        
        adjacencyList.get(fromNode).remove(toNode);
        
    }
    
    public void traverseDepthFirst(String root){
        Node node  = nodes.get(root);
        if(node == null)
            return;
        
        traverseDepthFirst(node, new HashSet<>());
    }
    private void traverseDepthFirst(Node root , Set<Node> visited){
        System.out.println(root);
        visited.add(root);
        
        for(Node node : adjacencyList.get(root)){
            if(!visited.contains(node))
                traverseDepthFirst(node, visited);
        }
    }
    
    public void traverseBreadthFirst(String root){
        Node node = nodes.get(root);
        if(node == null)
            return;
        
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node current = queue.remove();
            if(visited.contains(current))
                continue;
            
            System.out.println(current);
            visited.add(current);
            
            for(Node neighbour : adjacencyList.get(current)){
                if(!visited.contains(neighbour))
                    queue.add(neighbour);   
            }
        }
    }
    
    
}
