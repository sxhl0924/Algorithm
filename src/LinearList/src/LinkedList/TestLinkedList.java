package LinkedList;

public class TestLinkedList {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Anny");
        list.add("Tom");
        list.insert(1, "Holly");
        list.insert(2, "Sam");
        list.add("Olive");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("The length of list: " + list.length());
        System.out.println("The index of Anny: " + list.indexOf("Anny"));
        System.out.println("The 3rd: " + list.get(2));
        System.out.println("Remove the last: " + list.remove(4));
        System.out.println("The length of list: " + list.length());

        list.reverse();
    }
}

/*
public class TestLinkedList {
    public static void main(String[] args) throws Exception{
        DoublyLinkedList<String> list = new DoublyLinkedList<String>();
        list.add("Anny");
        list.add("Tom");
        list.add("Holly");
        list.add("Olive");
        list.insert(0,"Ava");
        list.insert(2,"Sam");


        for(String s:list){
            System.out.println(s);
        }

        System.out.println("The length of list: " + list.length());
        System.out.println("The index of Tom: " + list.indexOf("Tom"));
        System.out.println("The 3rd: " + list.get(2));
        System.out.println("The 1st: " + list.getFirst());
        System.out.println("The last: " + list.getLast());

        System.out.println("Remove the last: " + list.remove(4));
        System.out.println("The length of list: " + list.length());
        list.clear();
        System.out.println("The length of list: " + list.length());

        for(String s:list){
            System.out.println(s);
        }
    }

}
*/
