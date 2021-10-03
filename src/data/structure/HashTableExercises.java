package data.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {
    public int mostFrequent(int [] values){
        Map<Integer , Integer> table  = new HashMap<>();
        int count;
        for(int value:values){
            count = table.containsKey(value)? table.get(value) : 0;
            table.put(value , count+1);
        }
        
        int previus =0 ;
        for(int value : table.values()){
            if(value > previus ){
                previus = value;
            }
        }
        
        for(int key :table.keySet()){
            if(table.get(key) == previus)
                return key;
        }
        return 0;
    }
    
    public int countPairsWithDiff(int [] values , int k){
        if(values.length == 0)
            throw new IllegalStateException();
        
        Set <Integer> set  = new HashSet<>();
        for(int value:values){
            set.add(value);
        }
        int count = set.size();
        for(int value:values){
            int v = value+k;
            if(set.contains(v))
                continue;
            count--;
        }
        
        return count;
    }
    
    public int [] twoSum(int [] values  , int target){
        Map <Integer, Integer> table = new HashMap();
        for (int i = 0; i < values.length; i++) {
            int complement = target - values[i];
            if(table.containsKey(complement)){
                return new int[] { table.get(complement) , i};
            }
            table.put(values[i], i);
        }
        return null;
    }
    

}
