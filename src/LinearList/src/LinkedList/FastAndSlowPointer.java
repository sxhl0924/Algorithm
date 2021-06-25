package LinkedList;

public class FastAndSlowPointer {
    public static void main(String[] args){
        Node<String> first = new Node<String>("a",null);
        Node<String> second = new Node<String>("b",null);
        Node<String> third = new Node<String>("c",null);
        Node<String> fourth = new Node<String>("d",null);
        Node<String> fifth = new Node<String>("e",null);
        Node<String> sixth = new Node<String>("f",null);
        Node<String> seventh = new Node<String>("g",null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;

        //get the element in the mid node
        String mid = getMid(first);
        System.out.println("The mid element: " + mid);
    }
    public static String getMid(Node<String> first){
        Node<String> slow = first;
        Node<String> fast = first;
        /*fast pointer moves forward 2 nodes every step
        slow pointer moves forward 1 node every step
        when the fast pointer reaches the end, the slow pointer is on the middle
         */
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.item;
    }

}
