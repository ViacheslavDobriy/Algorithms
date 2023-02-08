package Seminar3;

public class MyCollection {

    private int[] array;
    private int capacity;
    private int length = 0;

    public MyCollection(int capacity){
        this.capacity = capacity;
        array = new int[this.capacity];
    }

    public MyCollection(){
        this.capacity = 10;
        array = new int[capacity];
    }

    public void add(int i) {
        array[length] = i;
        length++;
    }
}
