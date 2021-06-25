/*problem:
Build roads to connect 20 cities.
Now 7 roads have been built and some cities have been connected as listed below:
cityID cityID
0 1
6 9
3 8
5 11
2 12
6 10
4 8
Question: Is 9 and 10 connected? Is 9 and 8 connected?
* */


package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficProject1 {
    public static void main(String[] args) throws IOException {
        //read date from resource file
        BufferedReader reader = new BufferedReader(new InputStreamReader(TrafficProject1.class.
                getClassLoader().getResourceAsStream("traffic_project1")));
        //read the 1st line to get the city number
        int cityNum =Integer.parseInt(reader.readLine());
        //create a Graph to represent all cities
        Graph G = new Graph(cityNum);//each city is represented by a vortex in Graph G
        //read the 2nd line to get the number of already built roads
        int roadNum = Integer.parseInt(reader.readLine());
        //read the rest contents line by line, each line is a road that connects two cities
        while(roadNum>0){
            String [] cities = reader.readLine().split(" ");
            int c1 = Integer.parseInt(cities[0]);
            int c2 = Integer.parseInt(cities[1]);
            //add edge to the two cities to represent the road
            G.addEdge(c1, c2);
            roadNum--;
        }
        //create a BreadFirstSearch object with Graph G and vertex 9
        BreadthFirstSearch bfs = new BreadthFirstSearch(G,9);
        //use marked() method to known whether a vertex has been connected with 9
        boolean flag1 = bfs.marked(10);
        boolean flag2 = bfs.marked(8);

        System.out.println(flag1);
        System.out.println(flag2);
    }
}
