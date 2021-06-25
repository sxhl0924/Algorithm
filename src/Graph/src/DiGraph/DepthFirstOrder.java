package DiGraph;
import Stack.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> reversePost;//store the sequence of vortex

    public DepthFirstOrder(DiGraph DG){
        marked = new boolean[DG.getV()];
        reversePost = new Stack<Integer>();
        for(int v=0;v<DG.getV();v++){
            if(!marked[v]){
                dfs(DG, v);
            }
        }

    }

    //order vortexes in Graph
    private void dfs(DiGraph DG, int v){
        marked[v]=true;
        for(Integer w : DG.adj(v)){
            if(!marked[w]){
                dfs(DG,w);
            }
        }

        reversePost.push(v);
    }

    public Stack reversePost(){
        return reversePost;
    }
}
