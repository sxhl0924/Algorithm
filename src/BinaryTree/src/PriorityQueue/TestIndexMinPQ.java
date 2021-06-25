package PriorityQueue;

public class TestIndexMinPQ {
    public static void main(String[] args) {
        IndexMinPQ<String> iMinPQ = new IndexMinPQ<String>(10);
        iMinPQ.insert(0,"A");//
        iMinPQ.insert(1,"C");
        iMinPQ.insert(2,"F");
        iMinPQ.insert(3,"G");
        iMinPQ.insert(4,"R");

        System.out.println(iMinPQ.isExist(5));
        System.out.println(iMinPQ.size());
        System.out.println(iMinPQ.isEmpty());
        System.out.println(iMinPQ.delMin());
        System.out.println(iMinPQ.size());
        System.out.println(iMinPQ.IndexOfMin());
        iMinPQ.changeItem(1, "H");
        System.out.println(iMinPQ.IndexOfMin());
        iMinPQ.delete(1);
        System.out.println(iMinPQ.size());
        System.out.println(iMinPQ.IndexOfMin());










    }

}
