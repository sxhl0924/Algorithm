package Bubble;

public class Bubble {
    /*sort an array*/
    public static void sort(Comparable[] a){
        for (int i = a.length-1; i>0;i--){
            for(int j=0;j<i;j++){
                if(greater(a[j],a[j+1])){
                    exch(a, j, j+1);
                }
            }
        }

    }
    /*compare two elements*/
    public static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;//v>w
    }

    /*exchange two elements*/
    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
