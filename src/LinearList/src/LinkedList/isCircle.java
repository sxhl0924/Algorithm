package LinkedList;

public class isCircle {
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
        seventh.next = third;

        if(isCircle(first)){
            System.out.println("Circle found in list");
        }else {
            System.out.println("No circle in list");
        }

        Node entrance = getEntrance(first);
        System.out.println(entrance.item);
    }

    public static boolean isCircle(Node<String> first){
        Node<String> slow = first;
        Node<String> fast = first;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.equals(slow)){//if there is circle, fast will meet slow
                return true;
            }
        }
        return false;
    }
    /*when the slow and fast meets, create a new pointer to scan
    from the first node at the same speed of slow pointer, and
    when the new pointer meets the slow pointer,
    the node where they meet is the entrance of circle */
    public static Node getEntrance(Node<String> first){
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;
        while(fast!=null&&fast.next!=null){//
            fast = fast.next.next;
            slow = slow.next;

            if(fast.equals(slow)){
                temp = first;
                continue;
            }
            if(temp != null){
                temp=temp.next;
                if(temp.equals(slow)){
                    return temp;
                }
            }

        }
        return null;
    }

}