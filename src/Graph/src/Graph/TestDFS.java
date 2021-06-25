package Graph;

public class TestDFS {
    public static void main(String[] args){
        //create a new Graph object
        Graph g = new Graph(13);
        //add vortexes and edges to construct the graph
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,6);
        g.addEdge(0,5);
        g.addEdge(6,4);
        g.addEdge(4,3);
        g.addEdge(4,5);
        g.addEdge(3,5);
        g.addEdge(7,8);
        g.addEdge(9,10);
        g.addEdge(9,11);
        g.addEdge(9,12);
        g.addEdge(11,12);

        //create a DepthFirstSearch object
        BreadthFirstSearch DFS = new BreadthFirstSearch(g,0);

        System.out.println("7 and 0 is connected: "+ DFS.marked(7));
        System.out.println("10 and 0 is connected: "+ DFS.marked(10));
        System.out.println("6 and 0 is connected: "+ DFS.marked(6));
        System.out.println("4 and 0 is connected: "+ DFS.marked(0));
        System.out.println("12 and 0 is connected: "+ DFS.marked(12));

        System.out.println(DFS.count()+" vortexes connect with the vortex 0.");

    }




}
