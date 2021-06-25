package PriorityQueue;

public class TestMaxPriorityQueue {
    public static void main(String[] args){
        String[] arr = {"A", "B", "C", "D", "E", "F", "G"};
        //create a MaxPriorityQueue object
        MaxPriorityQueue<String> maxPQ = new MaxPriorityQueue<String>(10);

        //insert elements in arr to maxPQ
        for(String s : arr){
            maxPQ.insert(s);
        }

        System.out.println(maxPQ.size());
        while(!maxPQ.isEmpty()){
            String del = maxPQ.delMax();

            System.out.println(del);

        }
        System.out.println(maxPQ.size());
    }
}
