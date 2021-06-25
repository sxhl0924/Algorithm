package UnionFind;

import java.util.Scanner;

public class TestUnionFind {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);//input from the console
        System.out.println("Please input the number of element: ");
        int N =sc.nextInt();//store the input from the console5

        UnionFind uf = new UnionFind(N);
        while(true){

            System.out.println("Please input the 1st element you want to unite: ");
            int p = sc.nextInt();//store the 1st element input from the console
            System.out.println("Please input the 2nd element you want to unite: ");
            int q = sc.nextInt();//store the 2nd element input from the console

            if(uf.connected(p,q)){
                System.out.println("Node "+p+" Node "+q+" has been in the same group.");
                continue;
            }
            uf.union(p,q);
            System.out.println("There are "+uf.count()+ " groups left.");
        }
    }
}
