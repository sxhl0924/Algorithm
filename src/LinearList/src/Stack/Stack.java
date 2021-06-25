package Stack;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node head;
    private int N;
    //constructor
    public Stack(){
        head = new Node(null, null);
        N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    //pop up an element from the stack
    public T pop(){
        Node first = head.next;//the first element in the stack
        if(first == null){
            return null;
        }
        //delete first and return first.item
        head.next = head.next.next;
        N--;
        return first.item;

    }
    //push an element into the stack
    public void push(T t){
        Node first = head.next;
        Node newNode = new Node(t, first);//the new node becomes the first element
        head.next = newNode;
        N++;
    }

    @Override
    public Iterator<T> iterator(){
        return new SIterator();
    }
    public class SIterator implements Iterator<T>{
        private Node n = head;
        @Override
        public boolean hasNext(){
            return n.next != null;
        }
        @Override
        public T next(){
            Node node = n.next;
            n = n.next;
            return node.item;
        }
    }

    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

}
