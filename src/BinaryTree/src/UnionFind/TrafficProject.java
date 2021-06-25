
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
Question: how many roads should be added to ensure all 20
cities have been connected (directly or indirectly)?
* */

package UnionFind;
import java.io.BufferedReader;

import java.io.InputStreamReader;

public class TrafficProject {
    public static void main(String[] args) throws Exception {
        // create a BufferedReader object to read data from file
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (TrafficProject.class.getClassLoader().getResourceAsStream("traffic_project")));

        //read the 1st line to get the number of cities
        int cityNum = Integer.parseInt(reader.readLine());
        UFTree_weighted UFTw = new UFTree_weighted(cityNum);
        //read the 2nd line to get the number of built roads
        int roadNum = Integer.parseInt(reader.readLine());
        //read information of built roads
        for(int i=0;i<roadNum;i++){
            String line = reader.readLine();//format of line: cityID cityID
            //get the 1st and 2nd cityID of a connected road
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            //unite p and q to simulate the building of a connected road between p and q city
            UFTw.union(p,q);

        }
        //get the current group number
        int groupNum = UFTw.count();
        //when all cities have been connected, the groupNum will be 1; so the number of
        //roads need to be added is the current groupNum-1
        System.out.println((groupNum-1)+" more roads should be built to connect all cities.");


    }


}
