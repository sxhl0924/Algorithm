package Heap;

/*Solution: Put the max element in the last of heap. The max element is obtained by sinking
* all unsorted elements and getting the root element(max)*/

public class HeapSort {

    //sort elements from the given source in an increasing trend
    public static void sort(Comparable[] source){
        //1. create a new array to store data copied from source
        //The length of new array is 1 index larger than the source
        // because the data in new array starts from the index 1.
        Comparable[] heap = new Comparable[source.length +1];

        //2.create the new array heap by calling createHeap method
        createHeap(source,heap);

        //3.sort the heap
        //3.1 define an variant to store the max index
        int N = heap.length-1;

        while (N!=1) {
            //3.2 exchange the elements at index 1(root, max element) and index N
            exch(heap, 1, N);//after exch, the max element now is at index N, and now N
            N--;//

            //3.3 sink the element at index 1 in the range of 0~N
            sink(heap, 1, N);//after the sink process, the max element is placed in index 1.
        }//when N=1, all elements have been placed in an increasing order


        //4. now data in the heap has been sorted. copy the sorted heap to source
        System.arraycopy(heap, 1, source, 0, source.length);

    }

    //create a heap using the given source
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //1.copy the data from source to heap
        System.arraycopy(source,0,heap,1,source.length);

        //2.traverse the heap from the mid to root, and sink the element one by one
        //finally the heap will become a normal heap which follows the rule  that
        // the element of parent node is larger than all of its child nodes

        for(int i = (heap.length-1)/2; i>0; i--){
            sink(heap,i,heap.length-1);//sink range: i~heap.length-1
        }


    }

    private static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j])<0;

    }

    private static void exch(Comparable[] heap, int i, int j){
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }

    private static void sink(Comparable[] heap, int target, int range){
        //sink the target element
        while(2*target <= range){//2*target is the child node of target
            //compare target with the max of its left(2k) and right(2k+1) child nodes
            //1.find the max
            int max = 2*target;
            if(2*target+1<=range) {//the target has right node
                //compare the left and right and get the larger one
                if(less(heap,2*target,2*target+1)){
                    max=2*target+1;
                }
            }
            //compare the target with max, if the target is less than max,exchange them
            if(less(heap, target, max)){
                exch(heap, target, max);
            }
            target = max;//update the target to continue sinking until the target has no child node

        }

    }


}
