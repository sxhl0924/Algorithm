package DiGraph;

import Queue.Queue;

public class DiGraph {
    private final int V;//number of vortexes
    private int E;//number of edge
    private Queue[] adj;//adj[i] is a queue that stores all vortexes i pointing to; i->elements in adj[i]

    public DiGraph(int V){
        this.V = V;
        this.E = 0;
        //initialize adj []
        this.adj = new Queue[V];//each vortex should have a adj[]
        for(int i=0;i<V;i++){
            adj[i]=new Queue<Integer>();
        }
    }
    //get the number of vortexes in the graph
    public int getV(){
        return V;
    }
    //get the number of edges in the graph
    public int getE(){
        return E;
    }

    //add an edge v->w
    public void addEdge(int v, int w){
        //add w in the adjacency list of v (adj[v])
         adj[v].enqueue(w);
        //update the number of edges
        E++;
    }

    //get all vortexes that v points to
    public Queue<Integer> adj(int v){
        return adj[v];
    }

    //create the reversal graph of this graph
    private DiGraph reverse(){
        DiGraph r = new DiGraph(V);
        //traverse all vortexes of the digraph, from 0 to V-1
        for(int v=0;v<V;v++){
            //get the adjacency list of vortex v (adj(v));
            // the edge in the original digraph is v->w, and in the reverse digraph is w->v
            for(Integer w : adj(v)){
                //adj(v) stores all vortexes that v points to, add v to the adjacency list of w
                r.addEdge(w,v);
            }
        }
        return r;
    }


}
