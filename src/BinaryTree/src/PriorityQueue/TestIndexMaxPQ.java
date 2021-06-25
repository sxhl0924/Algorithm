package PriorityQueue;

public class TestIndexMaxPQ {
    public static void main(String[] args) {
        IndexMaxPQ<String> iMaxPQ = new IndexMaxPQ<String>(10);
        iMaxPQ.insert(0,"A");
        iMaxPQ.insert(1,"C");
        iMaxPQ.insert(2,"F");
        iMaxPQ.insert(3,"G");
        iMaxPQ.insert(4,"R");

        System.out.println(iMaxPQ.isExist(5));
        System.out.println(iMaxPQ.size());
        System.out.println(iMaxPQ.isEmpty());
        //System.out.println(iMaxPQ.delMax());
        //System.out.println(iMaxPQ.size());
        System.out.println(iMaxPQ.IndexOfMax());
        iMaxPQ.changeItem(4, "B");
        System.out.println(iMaxPQ.IndexOfMax());
       // iMaxPQ.delete(1);
        System.out.println(iMaxPQ.size());
        //System.out.println(iMaxPQ.IndexOfMax());


    }


}