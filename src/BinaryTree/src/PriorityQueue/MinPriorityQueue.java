package PriorityQueue;

public class MinPriorityQueue<T extends Comparable<T>> {
    private T[] items;//use an array to store elements
    private int N;//the number of elements

    //Constructor
    public MinPriorityQueue(int capacity){
        //initialize the array; the length of array is cap+1 because the index 0 doesn't store any element
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }


    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;//1111111
    }

    public void insert (T t){
        items[++N] = t;//add new element in the last of array
        swim(N);
    }

    public T delMin(){
        T min = items[1];
        exch(1, N);
        items[N] = null;
        /*the sequence of N-- and sink(1) is very important and cannot be exchanged,
         because in sink() method, N determines the exit of while loop. After deleting one
         element, we should update N first.*/
        N--;//***
        sink(1);//***
        return min;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }


    private void exch(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    //make sure the parent node(k/2) of the current is less than the current node(k)
    private void swim(int k){

        while(k/2>=1){//when the node k has a parent node
            //compare the current node k with its parent node k/2
            //if k/2 node is not less than k node, exchange them
            if(!less(k/2, k)){
                exch(k/2, k);
            }
            k = k/2;
        }

    }

    //make sure the current node is less than all of its child
    private void sink(int k){
        //when the current node(k) has left child node(2*k)
        while(2*k<=N){
            int min = 2*k;
            //when the current node also has right node, compare the left and right to find the smaller one
            if(2*k+1<=N){
                if(less(2*k+1, 2*k)){
                    min = 2*k+1;
                }
            }
            //compare the current node with the min of its child nodes
            if(less(k,min)){
                break;//if the current node is less than its child node, it is now in the correct position and do not need to make any changes.
            }

            exch(k, min);//exchange k and min if node k is larger than min
            k = min;//update k to continue sinking

        }

    }


}
