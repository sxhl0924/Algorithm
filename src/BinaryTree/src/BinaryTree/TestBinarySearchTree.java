package BinaryTree;

public class TestBinarySearchTree {
    public static void main(String[] args){
        BinarySearchTree<String, String> bst = new BinarySearchTree<>();
        bst.put("E", "5");
        bst.put("B", "2");
        bst.put("G", "7");
        bst.put("A", "1");
        bst.put("D", "4");
        bst.put("F", "6");
        bst.put("H", "8");
        bst.put("C", "3");

        System.out.println(bst.maxDepth());

       /* Queue<String> keys = bst.PreOrder();
        for(String key:keys){
            System.out.print(key);
        }
        System.out.println();

        Queue<String> ks = bst.InOrder();
        for(String key:ks){
            System.out.print(key);
        }
        System.out.println();*/



      /*  Queue<String> K = bst.PostOrder();
        for(String key:K){
            System.out.print(key);
        }*/

       /* System.out.println("The max Key: " + bst.max());
        System.out.println("The min Key: " + bst.min());*/

        /*System.out.println(bst.size());
        System.out.println(bst.get(1));
        System.out.println(bst.get(3));
        System.out.println(bst.get(4));
        System.out.println(bst.get(7));
        System.out.println(bst.get(9));*/

        /*bst.delete(1);
        bst.delete(4);
        System.out.println(bst.get(3));
        System.out.println(bst.get(4));

        System.out.println(bst.get(3));
        System.out.println(bst.size());*/

    }

}
