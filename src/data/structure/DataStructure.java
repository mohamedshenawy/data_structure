/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.structure;

/**
 *
 * @author shenawy
 */
public class DataStructure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(4);
        numbers.insert(5);
        numbers.insert(6);
        numbers.insert(7);
        numbers.insert(8);
        numbers.insert(20);
        numbers.insertAt(10, 2);
        numbers.print();
    }
    
}
