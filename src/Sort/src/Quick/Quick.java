package Quick;

public class Quick {
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);

    }

    private static void sort(Comparable[] a, int lo, int hi){
        if (lo>=hi){
            return;
        }
        int partition = partition(a,lo, hi);//get a partition index
        sort(a,lo,partition-1);//sort the left
        sort(a,partition+1,hi);//sort the right

    }

    private static int partition(Comparable[] a, int lo, int hi){
        int key = lo;//the index of the partition key
        int left = lo;//the starting index to scan a[] from left to right
        int right = hi;//the starting index to scan a[] from right to left
        while(true){
            while (right>=lo){//keep scanning until the right meets the left )
                if(less(a[right], a[key])){
                    break;//stop if a[right]< a[key] since the a[right] need to be moved to the left side
                }else{
                    right--;//keep scanning if a[right]>a[key]
                }
            }
            while(left<=hi){//keep scanning until the left meets the right
                if(less(a[key], a[left])){
                    break;
                    /*stop if a[left]>a[key] since the a[left] should
                    be shifted to the right of partition*/
                }else{
                    left++;//keep scanning if a[left]<a[key]
                }
            }

            if(left>=right){// the whole array has been scanned
                exch(a, key, right);//assign right/left to the index of the partition key
                break;
            }else{
                exch(a, left, right);
                /*exchange to place the smaller data on the left of
                a[key] and the larger data on the right*/
            }
        }
        return right;
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }


}
