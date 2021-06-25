package Heap;

public class Heap<T extends Comparable<T>>{
    private T[] items;//store elements
    private int N;//num of elements

    //constructor
    public Heap(int capacity){
        items = (T[]) new Comparable[capacity+1];//index 0 is blank
        N=0;
    }

    //delete the max element and return it
    public T delMax(){
        T max = items[1];//the 1st element is the max
        exch(1, N);//exchange the 1st and last(Nth) element
        items[N]=null;//delete the Nth (now the max);
        N--;
        sink(1);//find the right position for the old Nth element
        return max;

    }

    //insert an element in the heap
    public void insert(T t){
        items[++N] = t;//leave index 0 blank and store elements from index 1
        swim(N);

    }

    private boolean less(int i, int j){
        return items[i].compareTo(items[j])<0;
    }


    private void exch(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private void swim(int k){
        //let the element float up to a right position
        while (k > 1) {//kmin = 2, k/2=1 = root node
            //compare current node with its parent node
            if(less(k/2,k)){
                exch(k/2,k);
            }
            k=k/2;
        }
    }

    private void sink(int k){
        //let the element sink to a right position

        while(2*k<=N){//ensure the node at index k has child nodes (at index 2k).
            int max;//the index of the max node
            //find the max child node;2k+1 is the right child node of k; 2k is the left child node of k
            if(2*k+1<=N) {//there is a right node
                if (less(2 * k, 2 * k + 1)) {//compare the right and left node, set the larger one as max
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            }else {//no right node
                max =2*k;//directly return left node as max
            }
            //compare the current node k with the max of its child node
            //if node max child node is smaller than k, don't need to sink anymore.
            if (!less(k, max)) {
                break;
            } else {
                exch(k, max);//if the max child node is larger than the current node k,
                // sink k further by exchanging k and max.

                k = max;//update k to continue the sink process
            }



        }

    }

}
