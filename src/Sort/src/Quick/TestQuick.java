package Quick;

import java.util.Arrays;

public class TestQuick {
    public static void main(String[] args) throws Exception{
        Integer[] a = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        Quick1.sort(a);
        System.out.println(Arrays.toString(a));

    }
}
