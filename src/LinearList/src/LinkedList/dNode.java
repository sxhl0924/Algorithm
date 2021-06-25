package LinkedList;

public class dNode<T> {
    public T item;
    public dNode pre;
    public dNode next;

    public dNode(T item, dNode pre, dNode next){
        this.item = item;
        this.pre = pre;
        this.next = next;
    }

}
