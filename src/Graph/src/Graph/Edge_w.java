package Graph;

public class Edge_w implements Comparable<Edge_w>{
    private final int v;//the 1st vertex of edge
    private final int w;//the 2nd vertex of edge
    private final double weight;//the weight of edge

    public Edge_w(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //get the weight of edge
    public double weight(){
        return weight;

    }
    //get either vertex of edge
    public int either(){
        return v;
    }

    //get the other vertex of edge
    public int other(int vortex){
        if(vortex == v){
            return w;
        }else{
            return v;
        }
    }
    //compare the current edge with another edge (that)
    @Override
    public int compareTo(Edge_w that){
        if(this.weight()>that.weight()){
            return 1;
        }else if(this.weight()<that.weight()){
            return -1;
        }else{
            return 0;
        }
    }


}

