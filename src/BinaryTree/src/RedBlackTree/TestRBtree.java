package RedBlackTree;

public class TestRBtree {
    public static void main(String[] args){
        RedBlackTree<Integer, String> rb = new RedBlackTree<Integer, String>();

        rb.put(1, "a");
        rb.put(2, "b");
        rb.put(3, "c");

        System.out.println(rb.size());
        System.out.println(rb.get(2));
        System.out.println(rb.get(4));

        rb.put(1,"A");
        System.out.println(rb.get(1));

    }
}
