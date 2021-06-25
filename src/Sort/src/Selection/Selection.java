package Selection;

public class Selection {
    public static void sort(Comparable[] a){
        int min =0;
        for(int i = 0; i< a.length; i++){
            for(int j=i; j< a.length; j++){
                if(greater(a[min],a[j])){
                    min = j;
                }

            }
            exch(a, i, min);

        }

    }

    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }

    private static void exch(Comparable[]a,int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
