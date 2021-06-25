package Graph;
import Queue.Queue;

public class Graph {
    private final int V;//the number of vertex
    private int E;//the number of edges
    private Queue [] adj;//the adjacency list (array of Queue) used to store the connected vertexes

    public Graph(int V){
        this.V = V;
        this.E = 0;//no edge at initial condition.
        //initialize the adjacency list
        this.adj = new Queue[V];
        //initialize the Queue
        for(int i=0;i<adj.length;i++) {
            //each element in adj is a Queue that stores all vertexes connected with the index i of adj.
            adj[i] = new Queue<Integer>();
        }
    }

    public int getV(){
        return this.V;

    }

    public int getE(){
        return this.E;
    }
    //add an edge to connect two vertexes
    public void addEdge(int v, int w){
        //add w to the queue of v
        adj[v].enqueue(w);
        //add v to the queue of w
        adj[w].enqueue(v);
        //update Edge number;
        E++;
    }
    //get all vortexes connected with v
    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
