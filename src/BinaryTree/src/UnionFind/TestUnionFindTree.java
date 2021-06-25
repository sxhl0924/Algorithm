package UnionFind;
import java.util.Scanner;

public class TestUnionFindTree {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number of elements: ");
        int N = sc.nextInt();
        //The nextInt() method of Java Scanner class is used to scan the next token of the input as an int.

        UnionFindTree uft = new UnionFindTree(N);//
        while(true){
            System.out.println("Please input the first element you want to unite: ");
            int p = sc.nextInt();
            System.out.println("Please input the second element you want to unite:");
            int q = sc.nextInt();
            //check if p and q are in the same group
            if(uft.connected(p,q)){
                System.out.println("Node "+p+"and Node "+q+" have already been in the same group.");
                continue;
            }
            uft.union(p,q);
            System.out.println(uft.count() + "groups left now!");

        }
    }
}
