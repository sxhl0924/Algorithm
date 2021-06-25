package Heap;

public class TestHeap {
    public static void main(String[] args){
        Heap<String> heap = new Heap<String>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");




        String del;
        while((del=heap.delMax())!=null){
            System.out.println(del);
        }

    }
}
