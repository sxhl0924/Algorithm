package SymbolTable;

public class OrderedSymbolTable<Key extends Comparable <Key>, Value>{
    private int N;
    private Node head;

    public OrderedSymbolTable(){
        N = 0;
        head = new Node(null,null,null);
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    //put data in a increasing order of key
    public void put(Key k, Value v){
        Node<Key, Value> pre = head;
        Node<Key, Value> curr = head.next;
        while(curr!=null && k.compareTo(curr.key)>0){
            pre = curr;
            curr = curr.next;
        }//k>curr.key, continue traversing

        if(curr!=null&&curr.key.compareTo(k)==0){
            curr.value = v;
            return;
        }//k = curr.key, replace curr.value with v

        Node newNode = new Node(k,v,curr);
        pre.next = newNode;

        N++;
    }

    public void delete(Key k){
        Node curr = head.next;
        Node pre = head;

        while(curr.next!=null){
            pre = curr;
            curr = curr.next;
            if(k.equals(curr.key)){
                pre.next = curr.next;
                N--;
                return;
            }
        }
    }

    public Value get(Key k){
        Node<Key, Value> curr = head;
        while (curr.next!=null){
            curr = curr.next;
            if(curr.key.equals(k)){
                return curr.value;
            }
        }
        return null;
    }

    private class Node<Key,Value>{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

}
