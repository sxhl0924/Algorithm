package LinkedList;
/*problem: 41 people are standing in a circle and they are numbered as 1,2 ...41,respectively.
They are asked to count number. Everytime when someone counts number 3, he should leave the circle
and the person next to him begins to count from 1 again. Repeat the counting until there is
only 1 person left. Print the No of the last person.
*
* */

public class JosephusPermutation {
    public static void main(String [] args){
        //create a loop list
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for(int i = 1; i<=41;i++){
            if(i==1){
                first = new Node(i, null);
                pre = first;
                continue;
            }
            Node<Integer> node = new Node<Integer>(i, null);
            pre.next = node;//connect two nodes
            pre = node;
            if(i==41) {
                pre.next=first;//connect the last node and the first node to form a loop
            }
        }

        int count = 0;
        Node curr = first;//current node
        Node before = null;//the node before curr

        while(curr.next!=curr){//stop counting when only 1 node left
            count++;
            if(count==3){//delete the current node when count == 3;
                before.next = curr.next;
                System.out.println(curr.item);//print the current element
                count = 0;
                curr = curr.next;
            }else{//
                before = curr;//move forward to next node
                curr = curr.next;//move forward to next node
            }
            //curr = curr.next;
        }
       System.out.println(curr.item);
    }

}
