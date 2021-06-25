package PriorityQueue;

/*MaxPQ and MinPQ allow us to get min or max elements easily. But none of
them provide easy access to arbitrary elements.
* */

public class IndexMinPQ<T extends Comparable <T>> {
    private T[] items;//store elements (index1: element)
    private int[] pq;//store the index of element in items (index2: index1),
                     // pq array is ordered in the heap style
    private int[] qp;//the reversal array of pq (index1: index2)
    private int N;//num of elements in items

    //constructor
    public IndexMinPQ(int capacity){
        items = (T[]) new Comparable[capacity+1];
        pq = new int[capacity+1];
        qp = new int[capacity+1];
        int N = 0;
        for(int i=0; i < qp.length;i++){//qp(index1: index2)
            //set the default element of qp array as -1, which means that when
            // the items array is empty, index2 doesn't exist.
            qp[i]=-1;
        }

    }
    //items(index1, element); pq(index2, index1);qp(index1, index2)
    //delete min element in items and return index of min
    public int delMin(){
        //find the index of min element of items
        int minIndex = pq[1];
        //exchange the element at index 1 and N of pq == exchange
        // the index1 of min element and max element in items.
        exch(1, N);//after the exchange, now min element is at the last of pq (pq[N]),
        // and pq[1] is waiting to be adjusted by sink(1).
        //delete pq[N] means delete the index of min in pq
        pq[N] = -1;
        //delete the min element
        items[minIndex] = null;
        //update num of elements
        N--;
        //sink pq[1]
        sink(1);
        return minIndex;
    }

    public void insert(int i, T t){
        //if there has already been an element at index i
        if(isExist(i)){
            throw new RuntimeException("The index has already existed");
        }
        //update number of element
        N++;
        //store the element in items array
        items[i] = t;
        //add the index (i) of new element to pq heap array.
        pq[N] = i;//temporarily store i in the last of pq; awaiting to be adjusted by swim
        //also update the pq array
        qp[i] = N;
        //swim items[i] = items[pq[N]]
        swim(N); //swim() is a method for heap pq, so here we swim[N]

    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;

    }

    public boolean isExist(int k){
        //items(index1: element); pq(index2: index1); qp(index1: index2)
        /*To check whether the element at index1 k exists, use qp array
        because index of qp and items arrays (index1) are consistent, if no element at index1,
        the index2 doesn't exist.*/

        return qp[k]!=-1;
    }

    public void changeItem(int i, T t){
        //replace the element at index i with t
        items[i] = t;
        //since pq is ordered in heap according to the elements of element, the change of element in items will influence pq
        //we should find the index of 1 in pq and adjust its position

        int k = qp[i];//k is the index of i in pq
        swim(k);
        sink(k);
    }

    //index of the min element; items(index1: element); pq(index2: index1)
    //the element of pq (index1) is ordered by the corresponding element of index1 in items array
    // in the heap style. so the index of min element is the first element of pq
    public int IndexOfMin(){
        return pq[1];
    }


    //items(index1: element); pq(index2: index1); qp(index1: index2)
    //delete the element at index i
    public void delete(int i){
        //find the index of i in pq
        int k = qp[i]; //k = index2
        //exchange the element at index i and N of pq
        exch(k, N);//now k is at the last of pq, and N is in the position of k and is waiting for adjustment

        //delete the element in qp at index pq[N] (k)
        qp[pq[N]]=-1;
        //delete the element in pq at index N
        pq[N]=-1;
        //delete the element in items at index i
        items[i] = null;
        //update the num of elements in items
        N--;
        //adjust the position of k;both sink and swim should be performed to make sure k is placed correctly
        sink(k);//k is the old N
        swim(k);
    }

    //compare the element at index i and j of the heap array pq
    private boolean less(int i, int j){
        //items(index1: element); pq(index2: index1); qp(index1: index2)
        return items[pq[i]].compareTo(items[pq[j]]) < 0;//pq[i] is the index1 of items array
    }

    //exchange the element at index i and j of the heap array pq
    private void exch(int i, int j){
        //pq(index2: index1)//heap; index2 i j, index1 pq[i] pq[j]
        int temp = pq[i];
        pq[i]=pq[j];
        pq[j]=temp;

        //update the element of qp array (index2)
        // qp(index1: index2), reverse the heap pq
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }

    //swim the index k of pq
    private void swim(int k){
        //items(index1: element); pq(index2: index1); qp(index1: index2)
        //when the parent node (k/2) of k exists
        while(k/2>=1){
            //compare the elements in items at index of pq[k] and pq[k/2]
            if(less(k, k/2)){
                exch(k, k/2);
            }
            k = k/2;
        }
    }

    //sink the index k of pq
    private void sink(int k){
        //compare the left and right node of k and get the smaller one
        while(2*k<=N){
            int min = 2*k;
            if(2*k+1<=N){
                if(less(2*k+1, 2*k)){
                    min = 2*k+1;
                }
            }
            if(less(k, min)){
                break;
            }
            exch(k,min);
            k = min;

        }

    }

}
