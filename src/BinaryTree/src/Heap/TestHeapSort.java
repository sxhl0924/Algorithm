package Heap;

import java.util.Arrays;

public class TestHeapSort {
    public static void main(String[] args){
        String[] source = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        //Java String has implemented Comparable Interface
        HeapSort.sort(source);
        System.out.println(Arrays.toString(source));
    }
}
