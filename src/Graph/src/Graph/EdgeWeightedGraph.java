package Graph;
import Queue.Queue;

public class EdgeWeightedGraph {
    private final int V;//number of vertexes
    private int E;//number of edges
    private Queue<Edge_w>[] adj;//adj[i]: adjacency list of edges connected with i

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for(int i = 0; i<V;i++){
            adj[i]=new Queue<Edge_w>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }

    //add an edge e to the graph
    public void addEdge(Edge_w e){
        //get the 1st vertex of edge e
        int v = e.either();
        //get the 2nd vertex of edge e
        int w = e.other(v);
        //add e to the adjacency list of both v and w
        adj[v].enqueue(e);
        adj[w].enqueue(e);

        //update the number of edges
        E++;
    }

    //get edges connected with the vertex v
    public Queue<Edge_w> adj(int v){
        return adj[v];
    }

    //get all edges of the graph
    public Queue<Edge_w> edges(){
        //create a Queue to store all edges
        Queue<Edge_w> allEdges = new Queue<Edge_w>();
        //traverse vertexes and get the adjacency list of each vortex
        for(int v=0;v<V;v++){
            //traverse the adjacency list of the current vertex to get its edges
            for(Edge_w e : adj(v)){
                /*one edge is in the adjacency list of two vertexes,
                * so if we simply traverse all vertexes and get all their connected edges,
                * each edge will appear twice. To avoid duplication,
                * for each vertex v, we only get half of its adj(v)*/

                if(e.other(v)<v){
                    //e.other(v)=the other vertex connects with v through the edge e.
                    // v and e.other(v) is not equal, so one must be larger than the other
                    //now we set the rule that we store the edge only when the other vertex
                    // is smaller than v. by doing so, each edge will be recorded only once.
                    allEdges.enqueue(e);
                }

            }
        }
        return allEdges;
    }

}
