package PriorityQueue;

/*realize the priority Queue based on heap*/

public class MaxPriorityQueue<T extends Comparable<T>> {
    private T[] items;//the array used to store elements
    private int N;//the num of elements in the queue

    //Constructor
    public MaxPriorityQueue(int capacity){
        items = (T[])new Comparable[capacity + 1];
        N=0;
    }


    public T delMax(){
        //1. find the max
        T max = items[1];

        //2. exchange the max with the last element
        exch(1, N);

        //3.delete the last
        items[N] = null;
        N--;
        sink(1);

        return max;
    }

    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    private void swim(int k){
        //1.compare the current node with its parent node
        while(k/2>=1){//the current node has a parent node
            if(less(k/2, k)){//if the parent node is less than the current node,exchange them
                exch(k/2,k);
            }
            k = k/2;
        }

    }

    private void sink(int k){
        //1. check whether the node items[k] has child nodes and find the larger one
        while (2*k<=N){//2*k is the left child node of k
            int max = 2*k;
            if(2*k+1<=N){
                //when the right child node 2*k+1 also exists, compare 2*k and 2*k+1 to find the larger one
                if(less(2*k, 2*k+1)){
                    max = 2*k + 1;
                }
            }
            //2. compare the max and k
            if(less(max,k)){
                break;//if max < k, k is now in the correct position.
            }
            //if max > K, exchange them
            exch(max,k);
            k = max;
        }
    }

    private boolean less(int i, int j){
        return items[i].compareTo(items[j])<0;
    }

    private void exch(int i, int j){
        T temp = items[i];
        items[i]=items[j];
        items[j]=temp;
    }


    public int size(){

        return N;//not items.length!!!!

    }

    public boolean isEmpty(){

        return N==0;

    }


}
