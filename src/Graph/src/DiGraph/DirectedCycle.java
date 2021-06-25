package DiGraph;

public class DirectedCycle {
    private boolean[] marked;//marked[i] shows whether the vertex i has been searched or not
    private boolean hasCycle;//check if there is a cycle in the graph
    private boolean[] onStack;//onStack[i] indicates the vertex i has been on the path of searching

    DirectedCycle(DiGraph DG){
        marked = new boolean[DG.getV()];
        hasCycle = false;
        onStack = new boolean[DG.getV()];
        //traverse the graph, each vertex should serve as the entrance of searching to make sure
        // cycles wouldn't be missed.
        for(int v=0;v<DG.getV();v++){
            //if the current vertex has never been searched, search it
            if(!marked[v]){
                dfs(DG, v);
            }
        }

    }

    //detect the existence of cycle in the graph based on DepthFirstSearch
    private void dfs(DiGraph G, int v){
        //mark the current vertex v as searched
        marked[v] = true;
        //store the current vertex v in onStack,
        onStack[v]=true;
        //traverse the adjacency list of v, get all vertexes connected with v
        for(Integer w : G.adj(v)){
            //if w hasn't been searched, searched other vertexes connected with w
            if(!marked[w]){
               dfs(G,w);
            }

            //if w has been searched, check if w is also in onStack
            //w has been searched and has been in onStack shows that the searching path starting
            // from v has reached w before, indicating there has been a cycle in the graph.
            if(onStack[w]){
                hasCycle = true;
                return;//return when find the 1st cycle
            }
        }
        onStack[v]=false;
    }

    public boolean hasCycle(){
        return hasCycle;
    }
}
