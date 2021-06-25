package DiGraph;
import Stack.Stack;

public class TopoLogical {
    private Stack order;

    //constructor
    public TopoLogical(DiGraph DG){
        //create a DirectedCycle object to check if there is cycle in graph DG
        DirectedCycle dCycle = new DirectedCycle(DG);
        if(!dCycle.hasCycle()){
            //if no cycle, create a DepthFirstOrder object to order vertexes
            DepthFirstOrder dfo = new DepthFirstOrder(DG);
            order = dfo.reversePost();
        }

    }

    //check if the graph has cycle
    public boolean isCycle(){
        return order==null;
    }

    public Stack order(){
        return order;
    }
}
