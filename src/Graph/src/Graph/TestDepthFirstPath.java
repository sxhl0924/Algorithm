package Graph;

import Stack.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestDepthFirstPath {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (TestDepthFirstPath.class.getClassLoader().getResourceAsStream("path")));
        //get the city number and create a Graph
        int city_num = Integer.parseInt(reader.readLine());
        Graph G = new Graph(city_num);
        //get the number of roads
        int road_num = Integer.parseInt(reader.readLine());
        //add edge to the connected cities to present roads
        for(int i=0;i < road_num;i++){
            String[] cities = reader.readLine().split(" ");
            int c1 = Integer.parseInt(cities[0]);//the 1st city
            int c2 = Integer.parseInt(cities[1]);//the 2nd city
            G.addEdge(c1,c2);
        }

        DepthFirstPath paths = new DepthFirstPath(G,0);

        Stack<Integer> path = paths.pathTo(4);//path 0 to 4

        for(Integer p : path){
            System.out.print(p+" ");
        }

    }
}
