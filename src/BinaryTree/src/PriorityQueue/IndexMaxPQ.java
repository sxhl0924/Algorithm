package PriorityQueue;

public class IndexMaxPQ<T extends Comparable <T>> {
    private T[] items;//store the element
    private int[] pq;//store the index of element in items; pq is ordered by elements in items in a MaxPriorityQueue style.
    private int[] qp;//reversal array of pq; the index of qp is consistent with items
    private int N;//store the number of elements in items


    //Constructor
    IndexMaxPQ(int capacity){
        items = (T[]) new Comparable[capacity+1];
        pq = new int[capacity+1];
        qp = new int[capacity+1];
        N = 0;

        /*set default element of qp as -1; the element of qp is the
        index2(pq index) of the element index1 (items index) in original items array,
        which doesn't exist if items is empty. Set it as -1 will show easily whether one
        element exists in items.   */
        for(int i = 0; i<capacity+1;i++){
            qp[i]=-1;
        }

    }

    //compare the element in items corresponding to index i and j in pq.
    //pq[i] and pq[j] is the real index of elements in items
    private boolean less(int i, int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

    //exchange the element at index i and j
    //i and j are index of pq
    private void exch(int i, int j){
        //pq[i] and pq[j] is the real index of element in items
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        //update qp
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public int delMax(){
        int IndexOfMax = pq[1];//the index of max element is stored at the index 1 of pq
        exch(1, N);//exchange the pq[1] and pq[N], and now pq[N] is the index of max
        //delete max and update all related arrays
        qp[pq[N]]=-1;//set the index of max as -1
        pq[N]=-1;//set the index of (index of max) as -1
        items[IndexOfMax] = null;//delete the max element in items
        N--;
        //adjust the element at pq[1] through sink
        sink(1);//sink method is defined to operate the index of pq.
        return IndexOfMax;
    }

    //insert an element at index i
    public void insert(int i, T t){
        //if there has been an element at index  i
        if(isExist(i)){
            throw new RuntimeException("The index has already existed.");
        }
        //store i at index 1
        items[i]=t;
        N++;
        //update pq and qp
        pq[N]=i;
        qp[i]=N;
        //adjust the position of N in pq through swimming items[pq[N]]
        swim(N);
    }

    public boolean isExist(int i){
        return qp[i]!=-1;
    }

    //sink is defined to operate the index of pq
    private void sink(int k){//k is the index of pq
        //compare the child nodes of k and get the larger one

        while(2*k<=N){//k has left child node
            int Max = 2*k;
            if(2*k+1<=N && less(2*k, 2*k+1)){//k also has right node and right node is larger
                Max = 2*k+1;
            }

            //compare k and Max
            if(less(Max, k)){//less method compares the items related to index k and MaxIndex
                break;//when MaxIndex is less than k, just break because k is in the correct position
            }
            exch(Max, k);
            k = Max;
        }
    }

    public void swim(int k){
        //k is the index of pq array
        //compare k with its parent node
        while(k/2>=1){
            if(less(k/2, k)){
                exch(k/2, k);
            }
            k = k/2;
        }

    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void changeItem(int i, T t){
        items[i]=t;
        int k = qp[i];

        swim(k);
        sink(k);
    }

    public int IndexOfMax(){
        return pq[1];
    }

    public void delete(int i){
        items[i]=null;
        //update pq and qp
        int k = qp[i];//k is the index of items[i] in pq
        exch(k, N);//N is the index of last element in pq;after exchange, N is the deleted k
        qp[pq[N]]=-1;
        pq[N]=-1;
        N--;
        swim(k);
        sink(k);

    }

}
