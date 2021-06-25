package LinkedList;


import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node head;//the head node
    private int N;//the length of list

    //constructor
    public LinkedList() {
        head = new Node(null, null);
        N = 0;
    }

    //clear the list
    public void clear() {
        head.next = null;
        head.item = null;
        N = 0;
    }

    //check whether the list is empty
    public boolean isEmpty() {
        return N == 0;
    }

    //the length of list
    public int length() {
        return N;
    }

    //get the ith element
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("Illegal index");
        }
        Node<T> n = head.next;//the 1st node//why should add <T>?
        for (int j = 0; j < i; j++) {
            n = n.next;
        }//get the ith node
        return n.item;

    }

    //add an element
    public void add(T t) {
        Node n = head;
       /* for(int i=0; i<N;i++){
            n=n.next;
        }*/
        //find the last node
        while (n.next != null) {
            n = n.next;
        }
        Node newNode = new Node(t, null);
        n.next = newNode;
        N++;
    }

    //insert an element in the ith position
    public void insert(int i, T t) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("Illegal index");
        }
        Node pre = head;
        //find the (i-1)th node
        for (int j = 0; j <= i - 1; j++) {
            pre = pre.next;
        }
        //build a new node as the newly inserted ith node,
        // set its item = t, and set its next node as the old ith node(= pre.next) as
        Node curr = new Node(t, pre.next);
        //update the (i-1)node, set its next as the new node
        pre.next = curr;//now pre is the (i-1)th node, set its next as the newly inserted Node
        N++;
    }

    //delete the ith node and return the ith element
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("Illegal index");
        }
        Node pre = head;
        //find the (i-1)th node
        for (int j = 0; j <= i - 1; j++) {
            pre = pre.next;
        }
        //the current (ith) node
        Node<T> curr = pre.next;
        //set the next of the (i-1)th node as the old (i+1)th node
        pre.next = curr.next;
        N--;
        return curr.item;
    }

    //find the position where the element t first appears
    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;//t does not exist
    }

    public void reverse(){
        if (N==0){//empty list
            return;
        }
        reverse(head.next);

    } //reverse the whole list

    public Node reverse(Node curr){
        if (curr.next == null){//the exit of recursion
            head.next = curr;
            return curr;
        }

        Node pre = reverse(curr.next);
        pre.next = curr;
        curr.next = null;

        return curr;
    }//reverse a node

    public class Node<T> {
        public T item;
        public Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public Iterator iterator(){
        return new LIterator();

    }
    private class LIterator implements Iterator<T>{
        private Node<T> n;
        public LIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext(){
            return n.next!=null;
        }
        @Override
        public T next(){
            n=n.next;
            return n.item;
        }
    }




}
