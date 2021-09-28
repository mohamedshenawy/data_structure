/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structure;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 *
 * @author shenawy
 */
public class DataStructure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthNodeFromEnd(1));
        
        
    }
    
}
