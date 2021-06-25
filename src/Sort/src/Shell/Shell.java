package Shell;

public class Shell {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 1;
        while(h<N/2){
            h=h*2+1;
        }
        while(h>=1){
            for(int i=h; i<N; i++){
                for(int j=i;j>=h;j=j-h){
                    if(greater(a[j-h],a[j])){
                        exch(a,j,j-h);
                    }else{
                        break;
                    }
                }
            }
            h=h/2;
        }
    }

    private static boolean greater(Comparable v, Comparable w){
        return v.compareTo(w)>0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable temp = a [i];
        a[i]=a[j];
        a[j]=temp;
    }
}
