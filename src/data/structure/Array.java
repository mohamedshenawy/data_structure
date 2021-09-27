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
class Array {
    private int[] items;
    public int count;
    
    
    public Array(int length){
        items = new int[length];
    }    
    
    private void resizeArray(){
        //if the array is full , resize it
        if(items.length == count){
            //create anew array (twice the size )
            int [] newItems = new int[count*2];
            // cpoy items array
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            // set items to the newitems
            items = newItems;
        }
    }
    
    public void insert(int item){
        resizeArray();
        //add anew item at the end 
        items[count++] =item;
    }
    
    public void insertAt(int item , int index){
        //validation
        if(index<0 || index >count)
            throw new IllegalArgumentException();
        resizeArray();
        for (int i = count-1; i >= index; i--) {
            items[i+1] = items[i];
        }
        items[index] = item;
        
        count++;
    }
    
    public void removeAt(int index){
        //vaildate the index
        if (index<0 || index >= count) 
            throw new IllegalArgumentException();
        // shifting
        for(int i = index ; i<count;i++)
            items[i] = items[i+1];
        
        count--;
    }
    
    public int indexof(int item){
        
        for (int i = 0; i < count; i++) 
            if (items[i]== item)
                return i;
            
        
        return -1;
    }
    
    public int max(){   // time complexity : o(n)
        int max = 0;
        for (int i = 0; i < count; i++) {
            if(items[i]>max)
                max = items[i];
        }
        return max;
    }
    
    //ignord now
    public void intersect(){
    }
    
    public void reverse(){
        for (int i = count-1; i >= 0; i--)
            System.out.println(items[i]);    
    }
    
    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
    
}
