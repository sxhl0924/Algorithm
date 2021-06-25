package DiGraph;
import Stack.Stack;

public class TestTopoLogical {
    public static void main(String[] args){
        DiGraph dg = new DiGraph(6);
        dg.addEdge(0,2);
        dg.addEdge(0,3);
        dg.addEdge(2,4);
        dg.addEdge(3,4);
        dg.addEdge(4,5);
        dg.addEdge(1,3);

        TopoLogical DG = new TopoLogical(dg);

        System.out.println("dg has cycle: "+DG.isCycle());
        Stack<Integer> order = DG.order();

        StringBuilder sb = new StringBuilder();
        for(Integer s: order){
            sb.append(s+"->");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }
}
