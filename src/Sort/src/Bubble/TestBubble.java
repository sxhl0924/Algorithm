package Bubble;
import java.util.Arrays;

public class TestBubble {
    public static void main(String[] args){
        Integer[] a = {4, 5, 6, 3, 2, 1};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
