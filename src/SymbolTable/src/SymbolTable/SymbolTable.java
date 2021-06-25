package SymbolTable;

public class SymbolTable<Key, Value> {
    private Node head;
    private int N;

    public SymbolTable(){
        head = new Node(null, null, null);
        N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void put(Key k, Value v){
        Node n = head;
        //Traversing the queue to check if the key has already existed. If yes, replace its old value with v.
        while(n.next!=null){
            n = n.next;
            if(n.key.equals(k)){
                n.value = v;
                return;
            }
        }
        //if key dose not exist, put the new key/value in the queue
        Node oldFirst = head.next;
        Node newFirst = new Node(k,v,oldFirst);
        head.next = newFirst;
        N++;
    }

    public void delete(Key k){
        Node curr = head.next;
        Node pre = head;

        while(curr.next!=null){
            pre = curr;
            curr = curr.next;
            if(curr.key.equals(k)){
                pre.next = curr.next;
                N--;
                return;
            }
        }
    }

    public Value get(Key k){
        Node curr = head;
         while(curr.next!=null){
             curr = curr.next;
            if(curr.key.equals(k)){
                return curr.value;
            }
        }
        return null;
    }

    public class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node n){
            this.key = key;
            this.value = value;
            this.next = n;
        }

    }


}
