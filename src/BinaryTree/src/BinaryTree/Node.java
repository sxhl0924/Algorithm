package BinaryTree;

public class Node<Key, Value> {
    public Key key;
    public Value value;
    public Node<Key, Value> left;
    public Node<Key, Value> right;

    public Node (Key k, Value v, Node l, Node r){
        key = k;
        value = v;
        left = l;
        right = r;
    }
}
