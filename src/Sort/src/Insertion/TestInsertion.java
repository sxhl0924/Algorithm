package Insertion;

import java.util.Arrays;

public class TestInsertion {
    public static void main(String [] args){
        Integer[] a = {4, 3, 2, 10, 12, 1, 5, 6};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
