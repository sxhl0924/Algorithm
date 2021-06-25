package Graph;
import Queue.Queue;

/*BFS: when a vertex has both children and sibling vertexes,
search sibling vertexes first and then children vertexes*/

public class BreadthFirstSearch {
    private boolean[] marked;//marked[i]: whether the vertex i has been searched
    private int count;//the number of vertexes connected with the vortex s
    private Queue<Integer> waitSearch;//store the vertexes waiting to be searched

    //constructor
    public BreadthFirstSearch(Graph g, int s){

        marked = new boolean[g.getV()]; //g.getV() = total number of vertexes in Graph g
        waitSearch = new Queue<Integer>();
        bfs(g,s);// search the graph g from the vertex s

    }

    public void bfs(Graph g, int v){
        //mark the current vortex v as searched
        marked[v] = true;
        //put v in the waitSearch queue
        waitSearch.enqueue(v);
        //pop a vortex from waitSearch, and search the adj queue of the vortex
        while(!waitSearch.isEmpty()){
            Integer wait = waitSearch.dequeue();
            //traverse the adj of wait
            for(Integer w : g.adj(wait)) {
                if (!marked(w)) {
                    bfs(g, w);
                }
            }
        }
        count++;
    }

    //check if w is connected with s
    public boolean marked(int w){
        return marked[w];
    }
    //get the number of vortexes connected with s
    public int count(){
        return count;
    }

}
