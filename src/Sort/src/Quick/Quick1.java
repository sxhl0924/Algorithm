package Quick;

public class Quick1 {
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
        sort(a,lo,partition-1);//call the recursive sort function to sort the left group
        sort(a,partition+1,hi);//call the recursive sort function to sort the left group

    }

    /*using a[key] as the partition element to divide the array into two groups. on the left: a[left]<a[key];
        on the right, a[key]<a[right].  Calling the partition function recursively will finally
        result in a sorted array.*/

    private static int partition(Comparable[] a, int lo, int hi){
        int key = lo;//the index of the partition key
        int left = lo;//the starting index;scan a[] from left to right
        int right = hi+1;//the starting index;scan a[] from right to left


        while(true){
            while(less(a[key], a[--right])){
                if(right==lo){
                    break;
                }
            }
            while(less(a[++left],a[key])){
                if(left==hi){
                    break;
                }
            }

            /*Every time when we exit the above two loops, we found an element a[right](<a[key]) waiting
            to be moved to the left and an element a[left](>a[key]) waiting to be moved to the right.
            So just exchange them!*/

            if(left >= right){//the whole array has been scanned.
                //exch(a, key, right);
                break;
            }else{
                exch(a,right,left);
            }
        }
        exch(a, key, right);//the new partition key = right/left
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

