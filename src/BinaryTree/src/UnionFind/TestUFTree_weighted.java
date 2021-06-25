package UnionFind;

import java.util.Scanner;

public class TestUFTree_weighted {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);//a Scanner object used to read input from the console
        System.out.println("Please input the number of group: ");
        int N = sc.nextInt();   //receive the input int from the console
        UFTree_weighted UFTw = new UFTree_weighted(N);
        while(true){
            System.out.println("Please input the 1st element you want to unite: ");
            int p = sc.nextInt();
            System.out.println("Please input the 2nd element of group: ");
            int q = sc.nextInt();
            if(UFTw.connected(p, q)){
                System.out.println(p+" and "+q+" have already been in the same group.");
                continue;
            }
            UFTw.union(p,q);
            System.out.println("Currently, the number of group is "+UFTw.count());

        }


    }
}
