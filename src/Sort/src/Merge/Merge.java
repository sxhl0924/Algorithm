package Merge;

public class Merge {
    private static Comparable[] assist;//define an auxiliary array

    public static void sort(Comparable[] a){
        assist = new Comparable[a.length];//initialize the auxiliary array
        int lo = 0;//the min index of a
        int hi = a.length-1;//the max index of a
        sort(a,lo,hi);//call the overloaded recursive sort function
    }

    private static void sort  (Comparable[] a, int lo, int hi){
        if (hi<=lo){    //safety check
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a,lo, mid);
        sort(a,mid+1,hi);

        merge(a,lo,mid,hi);


    }

    /*divide the data to be sorted into two groups, lo to mid, and mid+1 to hi */
    private static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo;//index of assist []
        int p1 = lo;//beginning of the 1st group
        int p2 = mid+1;//beginning of the 2nd group
        while(p1<=mid && p2<=hi){
            //store the smaller data in assist[]
            if(less(a[p1],a[p2])){
                assist[i++]=a[p1++];
            }else{
                assist[i++]=a[p2++];
            }
        }
        /*when one of the two groups reached its end, the above while loop would be ended,
         but there may be remaining data in the other group. one of the following two
          while loops would execute depending on the exit condition of the above loop*/
        while (p1<=mid){ //store the remaining data in the 1st group to assist[]
            assist[i++]=a[p1++];
        }
        while(p2<=hi){  //store the remaining data in the 2nd group to assist[]
            assist[i++]=a[p2++];
        }

        /* at this time,  data from a[lo] to a[hi] have been sorted and stored in assist[]*/
        /*copy data in assist[] to original array*/
        for(i=lo; i<=hi;i++){
            a[i]=assist[i];
        }
    }

    private static boolean less(Comparable w, Comparable v){
        return w.compareTo(v)<0;
    }


}
