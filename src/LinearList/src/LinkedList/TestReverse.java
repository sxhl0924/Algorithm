package LinkedList;

public class TestReverse {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("-------------------------------");
        list.reverse();
        for(Integer i : list){
            System.out.print(i + " ");
        }
    }
}
