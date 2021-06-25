package BinaryTree;
import Queue.Queue;

/*Fold a paper from down to up for N times and print the direction of all creases.
Eg, N=1, down;N=2, down down up */

public class PaperFolding {
    public static void main(String[] args){
        //create a tree to present creases
        Node tree = createTree(3);
        //traverse the tree and print the direction
        printTree(tree);

    }

    private static void printTree(Node tree){
        //print in InOrder
        if(tree == null){
            return;
        }
        printTree(tree.left);
        System.out.print(tree.item+",");
        printTree(tree.right);


    }

    //define Node class
    private static class Node{
        String item;
        Node left;
        Node right;
        public Node(String item, Node left, Node right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /*Create a tree to to simulate the paper folding process.
    * The depth of the tree is N, which equals to the folding times.
    * Folding one more time means adding a new level to the tree.
    * Root node = "down", left Node = "down", right Node = "right"
    *  */
    public static Node createTree(int N){
        Node root = null;//initialize the root as null
        for(int i = 0;i<N;i++){//simulate the process of folding N times
            if(i==0){
                //1st folding, only 1 crease, and set it as the root node
                root = new Node("down",null,null);
            }else{
                //from the 2nd folding, create a queue to save the root
                Queue<Node> nodes = new Queue<Node>();
                nodes.enqueue(root);
                //traverse the Queue nodes
                while(!nodes.isEmpty()){
                    //1. take one node from nodes
                    Node tmp = nodes.dequeue();
                    //2.if the current node has left node, save the left node in nodes queue
                    if(tmp.left!=null){
                        nodes.enqueue(tmp.left);
                    }
                    //3.if the current node has right node, save the right node in nodes queue
                    if(tmp.right!=null){
                        nodes.enqueue(tmp.right);
                    }
                    //3.if the current node has neither left nor right node, create a new left ("down" and
                    //new right("up") node from this node
                    if(tmp.left==null&&tmp.right==null){
                        tmp.left = new Node("down",null,null);
                        tmp.right = new Node("up",null,null);
                    }

                }//when exit the while loop, all nodes at level i have
                // been attached with a new left node and a new right node
                // and the (i+1)th folding has been completed then.
            }
        }
        return root;
    }
}
