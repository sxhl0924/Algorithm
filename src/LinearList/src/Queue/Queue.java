package Queue;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    private Node head;
    private int N;
    private Node last;

    public Queue(){
        head = new Node(null,null);
        N = 0;
        last = null;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public T dequeue(){
        if(isEmpty()){//the queue is empty
            return null;
        }
        Node<T> oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        if(isEmpty()){//the queue becomes empty,
            last=null;//**********Why should we do this?
        }
        return oldFirst.item;
    }

    public void enqueue(T t){
        if(last == null){
            last = new Node(t, null);
            head.next = last;
        }else{
            Node oldLast = last;
            last = new Node(t,null);
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public Iterator<T> iterator(){
        return new QIterator();
    }

    private class QIterator implements Iterator<T>{
        private Node n = head;
        @Override
        public boolean hasNext(){
            return n.next != null;
        }
        @Override
        public T next(){
            Node<T> node = n.next;
            n = n.next;
            return node.item;
        }

    }

    private class Node<T>{
        private T item;
        private Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }

    }

}
