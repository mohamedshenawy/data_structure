package data.structure;

import java.util.Arrays;
import java.util.List;


public class DataStructure {

    public static void main(String[] args) {
        Graph graph =new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");
        graph.traverseBreadthFirst("A");
    }
    
}
