package PriorityQueue;

public class TestMinPriorityQueue {
    public static void main(String[] args){
        MinPriorityQueue<String> mq = new MinPriorityQueue<>(10);
        mq.insert("D");
        mq.insert("A");
        mq.insert("C");
        mq.insert("B");
        mq.insert("E");
        System.out.println("Size: "+mq.size());

        String del;
        del = mq.delMin();//1111111
        System.out.println(del);

        while(!mq.isEmpty()){
            del = mq.delMin();
            System.out.print(del+" ");
        }

    }




}
