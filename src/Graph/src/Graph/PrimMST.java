package Graph;

import PriorityQueue.IndexMinPQ;
import Queue.Queue;

public class PrimMST {
    //edgeTo[i] represents the shortest edge from the current vertex i
    //to the min spanning tree (MST)
    private Edge_w[] edgeTo;

    //distTo[i] represents the weight of shortest path from vertex i to SMT (edgeTo[i])
    private double[] distTo;

    //mark true if the vertex has been in the MST, otherwise mark false
    private boolean[] marked;

    //store the cross-cut edge of vertexes in the tree and outside the tree
    private IndexMinPQ<Double> pq;

    //use a weighted non-directed graph to create a PrimMST object
    public PrimMST(EdgeWeightedGraph G) {
        //initialize edgeTo[];
        this.edgeTo = new Edge_w[G.V()];

        //initialize distTo[]
        this.distTo = new double[G.V()];

        //set the default value of distTo[i] as POSITIVE_INFINITY,
        // indicating that the edge does not exist
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        //initialize marked[]
        this.marked = new boolean[G.V()];

        //create IndexMinPriorityQueue pq
        this.pq = new IndexMinPQ<Double>(G.V());

        //in default, the vertex 0 is the first vertex in the MST, and 0 hasn't been connected
        // with any other vertexes, so set the weight of edge connected with 0 as 0.0
        distTo[0]=0.0;

        //initialize pq with vertex 0 and its weight 0.0 (distTo[0]=0.0)
        pq.insert(0,0.0);
        while (!pq.isEmpty()){
            visit(G,pq.delMin());
        }


    }

    //add vertexes in the MST and update data
    private void visit(EdgeWeightedGraph G, int v){
        //add vertex v in MST
        marked[v]=true;
        //traverse the adjacency list of v, to get each edge e connected with v
        for(Edge_w e : G.adj(v)){
            //find the other vertex of edge e
            int w = e.other(v);
            //check if w has been in the MST, if yes, continue to scan other vertexes
            if(marked[w]){
                continue;
            }
            //if w is not in the MST, correct the edge of w to MST edgeTo[w], it weight distTo[w], and cross-cut edges
          //compare
            if(pq.isExist(w)){
                pq.changeItem(w,e.weight());

            }else{

                pq.insert(w,e.weight());
            }
        }

    }

    public Queue<Edge_w> edges(){
        //create a new queue
        Queue<Edge_w> edges = new Queue<Edge_w>();
        //traverse edgeTo[], to get each edge and add to edges
        for(int i=0;i<marked.length;i++){
            if(edgeTo[i]!=null){
                edges.enqueue(edgeTo[i]);
            }
        }
        return edges;
    }
}
