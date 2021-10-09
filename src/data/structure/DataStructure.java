package data.structure;


public class DataStructure {

    public static void main(String[] args) {
        Tree obj = new Tree();
        obj.insert(7);
        obj.insert(22);
        obj.insert(4);
        obj.insert(9);
        obj.insert(1);
        obj.insert(6);
        obj.insert(8);
        obj.insert(10);
        obj.insert(15);
        obj.insert(18);
        System.out.println(obj.areSibling(4, 6));
        System.out.println(obj.getAncestors(18));
    }
    public static int factorial(int n){
        if(n == 0)
            return 1;
        return n * factorial(n-1);
    }
    
}
