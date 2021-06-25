package RedBlackTree;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;//the root node
    private int N;//the num of elements in the tree
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    //constructor
    public RedBlackTree(){

    }

    //check the color of the link points to Node x
    private boolean isRed(Node x){
        if(x==null){
            return false;//null node is black in default
        }
        return x.color == RED;
    }

    //adjust the node by left rotation
    //when the right child node of the current is RED, the current node needs a left rotation
    private Node rotateLeft(Node h){
        //find the right child node of the current node
        Node hRight = h.right;
        //set the hRight as the left child node of current node
        h.right = hRight.left;
        //set h as the left child node of
        hRight.left = h;
        hRight.color = h.color;
        h.color = RED;

        return hRight;

    }

    //adjust the node h by right rotation
    //when both curr.left and curr.left.left are RED,
    private Node rotateRight(Node h){
        Node hLeft = h.left;
        h.left = hLeft.right;
        hLeft.right = h;
        hLeft.color = h.color;
        h.color = RED;
        return hLeft;
    }

    //flip color
    //when both the left and right child nodes of the current are RED, we should flip
    //the color of current, left and right child nodes.
    private void flipColors(Node h){

        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;

    }

    //add an element to the tree
    public void put(Key k, Value v){
        root = put(root, k, v);
        root.color = BLACK;//the color of root is always BLACK.
    }

    //add an element (k, v) to h node (subtree), and return the new node (subtree)
    private Node put(Node<Key, Value> h, Key k, Value v){
        if(h==null){
            N++;
            //connect with root node with red link
            return new Node(k,v,null,null,RED);
        }

        //compare the target (k,v) to the current node h
        int cmp = k.compareTo(h.key);
        if(cmp<0){
            //continue to find the left child node to put (k,v)
            h.left = put(h.left, k, v);
        }else if(cmp>0){
            //continue to find the right child node to put (k,v)
            h.right = put(h.right, k, v);
        }else{//k = h.key
            h.value = v;
        }

        /*check the color of child nodes and make suitable adjustment to make sure
        the tree is in a normal status*/

        //if the right child node of current node is red, and left child node is black.
        //do a left rotation
        if(isRed(h.left) && !isRed(h.right)){
            h = rotateLeft(h);
        }

        //if the left child node and left of left child node are both red,
        //do a right rotation
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }

        //if the left and right child nodes of the current are both red,
        //do a color flip
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        return h;

    }

    //get the value from the tree by key
    public Value get(Key key){
        return get(root, key);

    }

    public Value get(Node<Key, Value> x, Key k){
        if(x==null){
            return null;
        }

        //compare the target key with the key of current node
        int cmp = k.compareTo(x.key);
        if(cmp<0){
            x = x.left;
            return get(x, k);
        }else if(cmp>0){
            x=x.right;
            return get(x,k);
        }else{
            return x.value;
        }

    }

    public int size(){
        return N;
    }






}
