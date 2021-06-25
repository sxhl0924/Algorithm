package LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private dNode<T> head;//the head node of DLL
    private dNode<T> last;//the last node of DLL
    private int N;//the length of DLL

    //Constructor
    public DoublyLinkedList(){
        last = null;
        head = new dNode(null, null, null);
        N=0;
    }

    public void clear(){
        last = null;
        head.next = null;//or head.next = last
        head.pre = null;
        head.item = null;
        N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int length(){
        return N;
    }

    public T get(int i){
        if(i<0||i>=N){
            throw new RuntimeException("Illegal Index");
        }
        dNode<T> n = head;
        //find the node at index i
        for (int j= 0; j<=i;j++){
            n=n.next;
        }
        return n.item;
    }

    public void add(T t){//
        if(last == null){
            last = new dNode<T>(t,head,null);
            head.next = last;
        }else{
            dNode oldlast = last;
            dNode newNode = new dNode(t, oldlast, null);
            oldlast.next = newNode;
            last = newNode;
        }
        N++;
    }

    public void insert(int i, T t){
        if(i<0||i>=N){
            throw new RuntimeException("Illegal Index");
        }
        dNode pre = head;
        //find the node at index i-1
        for(int j=0;j<i;j++){
            pre=pre.next;
        }

        dNode curr = pre.next;//the node at index i
        dNode newNode = new dNode(t,pre,curr);//insert i at index i, curr becomes the next of the inserted node
        pre.next = newNode;
        curr.pre = newNode;
        N++;
    }

    public T remove(int i){
        if(i<0||i>=N){
            throw new RuntimeException("Illegal Index");
        }
        dNode pre = head;
        //find the node at index i-1
        for(int j=0; j<i;j++){
            pre=pre.next;
        }
        dNode<T> curr = pre.next;//the node at index i

        dNode curr_next = curr.next;
        pre.next = curr_next;
        curr_next.pre = pre;
        N--;
        return curr.item;

    }

    public int indexOf(T t){
        dNode n=head;
        for(int i=0; n.next!=null;i++){
            n=n.next;
            if(n.item.equals(t)){
                return i;
            }
        }
        return -1;//t does not exist
    }

    public T getFirst(){
        if(isEmpty()){
            return null;
        }
        dNode<T> first = head.next;
        return first.item;
    }

    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    @Override
    public Iterator<T> iterator(){
        return new TIterator();
    }
    private class TIterator implements Iterator {
        private dNode n = head;

        @Override
        public boolean hasNext(){
            return n.next!=null;
        }

        public Object next(){//?
            n=n.next;
            return n.item;
        }
    }

}
