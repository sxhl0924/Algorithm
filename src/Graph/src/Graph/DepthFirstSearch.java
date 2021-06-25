package Graph;

/*DFS: when a vortex has both children vortexes and sibling vortexes,
search children vortexes first and then sibling vortex */

public class DepthFirstSearch {
    private boolean[] marked;//index = a vortex; element = whether the vertex has been searched
    private int count;//the number of vertexes connected with vortex s

    public DepthFirstSearch(Graph G, int s){
        //initialize boolean[] marked
        marked = new boolean[G.getV()];//G.getV()=the number of vertexes in G
        //search vertexes connected with s
        dfs(G,s);
    }

    //define dfs method to search vertexes connected with v
    private void dfs(Graph G, int v){
        //1. mark the current vertex as searched
        marked[v] = true;
        //traverse the adjacency list of vertex v
        //adj() method returns the queue which stores all vertexes connected with v
        //Queue API has overrode the iterator, so we can use the enhanced for loop to traverse
        for( Integer w : G.adj(v)){
            //if the current vertex w hasn't been searched,
            // search vertexes connected with w by calling dfs(G,w) recursively.
            if(!marked[w]){
                dfs(G,w);
            }

        }
        count++;//every time dfs() method is called, the number of vertexes connected with w plus one.
    }

    //check whether vertex w is connected with s
    public boolean marked(int w){
        return marked[w];

    }

    //get the total number of vertexes connected with s
    public int count(){
        return count;

    }













}
