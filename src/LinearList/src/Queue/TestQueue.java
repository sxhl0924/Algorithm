package Queue;

public class TestQueue {
    public static void main(String[] args){
        Queue<String> queue = new Queue<String>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");

        System.out.println("The size of queue: "+ queue.size());
        for(String str:queue){
            System.out.println(str);
        }

        String s = queue.dequeue();
        System.out.println(s);
        System.out.println("The size of queue: "+ queue.size());

        s = queue.dequeue();
        System.out.println(s);
        System.out.println("The size of queue: "+ queue.size());



    }
}
