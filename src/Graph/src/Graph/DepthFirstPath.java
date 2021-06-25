/*problem:
* 6---vortex number
* 8---edge number
* 0 2
* 0 1
* 2 1
* 2 3
* 2 4
* 3 5
* 3 4
* 0 5
* Question: find the path from 0 to 4
* */

package Graph;
import Stack.Stack;

public class DepthFirstPath {
    private boolean[] marked;//marked[i] indicates whether the vertex i has been searched
    private int s;//the starting vortex
    private int[] edgeTo;//edgeTo[i] is the last vertex connected with the vertex i in the path from s to i

    public DepthFirstPath(Graph G, int s){
        //initialize the boolean array marked
        marked = new boolean[G.getV()]; // length of array = number of vertexes
        //initialize the starting vertex
        this.s = s;
        //initialize the int[] edgeTo
        edgeTo = new int[G.getV()];//size of edgeTo is the same with the number of vertexes
        //search all paths starting from the vertex s
        dfs(G,s);
    }

    //use DepthFirstSearch to find all vertexes connected with the vertex v
    private void dfs(Graph G, int v){
        //mark the current vertex as searched
        marked[v]=true;
        //traverse the adjacency list of v, to get every vertex connected with v
        for(Integer w : G.adj(v)){
            //if the current vertex w has never been searched, set v as the last vertex of w
            if(!marked[w]){
                edgeTo[w]=v;
                //continue to search the vertexes connected with w by recursively calling dfs
                dfs(G,w);
            }
        }

    }

    //check if there is path from the starting vortex s to the vertex v
    public boolean hasPathTo(int v){
        return marked[v];//if there is a path from s to v, v must have been searched
    }

    //find the path from the starting vortex s to the vertex v
    public Stack<Integer> pathTo(int v){
        //when v and s is not connected, no path
        if(!hasPathTo(v)){
            return null;
        }
        //create a Stack container to store all vertexes in a path
        Stack<Integer> path = new Stack<Integer>();
        //firstly store the current vortex, and move the current vortex to
        // its previous vortex using edgeTo[]
        while(v!=s){
            path.push(v);
            v = edgeTo[v];//edgeTo[v] is the last vertex connected with v in the path
        }
       /* for(int x=v;x!=s;x=edgeTo[x]){
            path.push(x);
        }*/

        //finally, put the starting vertex s into path
        path.push(s);
        return path;


    }


}
